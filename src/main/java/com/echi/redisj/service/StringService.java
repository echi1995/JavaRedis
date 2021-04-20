package com.echi.redisj.service;

import com.echi.redisj.common.NodeTypeEnum;
import com.echi.redisj.dao.Node;
import com.echi.redisj.dao.NodeHolder;
import com.echi.redisj.dao.NodeHolderFactory;
import com.echi.redisj.dao.StringNode;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/20 10:32 上午
 */
@Service
public class StringService {

    NodeHolder holder = NodeHolderFactory.holder;

    public String get(String key){
        Assert.notNull(key, "key is not null");
        Node node = holder.get(key);
        if (node == null || !NodeTypeEnum.STRING.equals(node.type())) {
            return null;
        }
        return (String)node.get();
    }

    public String getRange(String key, Integer start, Integer end){
        Assert.notNull(key, "key is not null");
        Assert.notNull(start, "start is not null");
        Assert.notNull(end, "end is not null");
        Assert.isTrue(start <= end, "start should lte end");

        Node node = holder.get(key);
        if (node == null || !NodeTypeEnum.STRING.equals(node.type())) {
            return null;
        }
        String res = (String)node.get();
        if (end <= res.length()) {
            return res.substring(start, end);
        }else {
            if (start <= res.length()) {
                return res.substring(start);
            }
            return "";
        }
    }

    public String getSet(String key, String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");
        Node node = holder.get(key);
        if (node == null) {
            return null;
        }
        String ret ;
        if (!NodeTypeEnum.STRING.equals(node.type())) {
            ret = String.valueOf(node.get());
            StringNode newNode = new StringNode(key, value.toCharArray());
            holder.put(key, newNode);
        }else {
            ret = (String)node.get();
            node.set(value);
        }
        return ret;
    }

    public int getBit(String key, Integer offset){
        Assert.notNull(key, "key is not null");
        Assert.notNull(offset, "offset is not null");
        Node node = holder.get(key);
        if (!NodeTypeEnum.STRING.equals(node.type())) {
            return 0;
        }
        return ((StringNode) node).getBit(offset);
    }

    public List<String> mGet(List<String> keys){
        Assert.notNull(keys, "key is not null");
        List<String> res = new ArrayList<>();

        for (String key : keys) {
            Node node = holder.get(key);
            if (!NodeTypeEnum.STRING.equals(node.type())) {
                res.add(String.valueOf(node.get()));
            }else {
                res.add((String)node.get());
            }
        }
        return res;
    }

    public boolean setBit(String key, int offset, int value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(offset, "offset is not null");
        Assert.notNull(value, "value is not null");

        Node node = holder.get(key);
        if (!NodeTypeEnum.STRING.equals(node.type())) {
            return false;
        }
        return ((StringNode)node).setBit(offset, value);
    }

    public boolean setEx(String key,long second,String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(second, "second is not null");
        Assert.notNull(value, "value is not null");
        Node node = holder.get(key);
        if (!NodeTypeEnum.STRING.equals(node.type())) {
            StringNode newNode = new StringNode(key, value.toCharArray());
            newNode.expire(second);
            holder.put(key, newNode);
        }else {
            node.set(value.toCharArray());
            node.expire(second);
        }
        return true;
    }

    public boolean setNx(String key,String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        if (holder.containsKey(key)) {
            return false;
        }
        StringNode node = new StringNode(key, value.toCharArray());
        holder.putIfAbsent(key, node);
        return true;
    }

    public void setRange(String key, String offset,String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(offset, "offset is not null");
        Assert.notNull(value, "value is not null");

    }

    public void strLen(String key){
        Assert.notNull(key, "key is not null");

    }

    public void mSet( List<String[]> keys){
        Assert.notNull(keys, "key is not null");

    }

    public void mSetNX(List<String[]> keys){
        Assert.notNull(keys, "key is not null");

    }

    public void incr(String key){
        Assert.notNull(key, "key is not null");

    }

    public void incrBy(String key,Integer increment){
        Assert.notNull(key, "key is not null");
        Assert.notNull(increment, "increment is not null");

    }

    public void decr(String key){
        Assert.notNull(key, "key is not null");

    }

    public void decrBy(String key, Integer increment){
        Assert.notNull(key, "key is not null");
        Assert.notNull(increment, "increment is not null");
        StringBuilder stringBuilder = new StringBuilder();
    }

    public void append(String key, String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

    }

}
