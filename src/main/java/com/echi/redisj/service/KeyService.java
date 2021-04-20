package com.echi.redisj.service;

import com.echi.redisj.common.NodeTypeEnum;
import com.echi.redisj.dao.Node;
import com.echi.redisj.dao.NodeHolder;
import com.echi.redisj.dao.NodeHolderFactory;
import com.echi.redisj.dao.StringNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author chengxiaoxiao
 * @date 2021/4/19 11:45 上午
 */
@Service
public class KeyService {

    NodeHolder holder = NodeHolderFactory.holder;

    public void set(String key, String value){
        holder.put(key, new StringNode(key, value.toCharArray()));
    }

    public void del(String key){
        holder.remove(key);
    }

    public boolean exists(String key){
        Assert.notNull(key, "key is not null");
        return holder.containsKey(key);
    }

    public void expire(String key,  String seconds){
        Assert.notNull(key, "key is not null");
        Assert.notNull(seconds, "seconds is not null");

        Node node = holder.get(key);
        node.expire(Long.parseLong(seconds));

    }

    public List<String> keys(String pattern){
        Assert.notNull(pattern, "pattern is not null");
        Set<String> strings = holder.keySet();
        Pattern compile = Pattern.compile(pattern);
        List<String> res = new ArrayList<>();
        for (String string : strings) {
            Matcher matcher = compile.matcher(string);
            if (matcher.matches()) {
                res.add(string);
            }
        }
        return res;
    }

    public void persist(String key){
        Assert.notNull(key, "key is not null");
        Node node = holder.get(key);
        // 如果已经过期
        if (!node.presist()) {
            holder.remove(key);
        }
    }

    public long ttl(String key){
        Assert.notNull(key, "key is not null");
        Node node = holder.get(key);
        return node.ttl();
    }

    public void randomKey(){ }

    public boolean rename(String key, String newKey){
        Assert.notNull(key, "key is not null");
        Assert.notNull(newKey, "newKey is not null");
        if (holder.containsKey(newKey)) {
            return false;
        }
        Node node = holder.get(key);
        holder.remove(key);
        holder.put(newKey, node);
        return true;
    }

    public NodeTypeEnum type(String key){
        Node node = holder.get(key);
        return node.type();
    }


}
