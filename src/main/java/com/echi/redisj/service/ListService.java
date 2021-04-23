package com.echi.redisj.service;

import com.echi.redisj.common.NodeTypeEnum;
import com.echi.redisj.dao.ListNode;
import com.echi.redisj.dao.Node;
import com.echi.redisj.dao.NodeHolder;
import com.echi.redisj.dao.NodeHolderFactory;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/21 5:07 下午
 */
public class ListService {


    NodeHolder holder = NodeHolderFactory.holder;

    public void bLPop(String key, Long timeout){
        Assert.notNull(key, "key is not null");
        Assert.notNull(timeout, "timeout is not null");

    }

    public void bRPop(String key, Long timeout){
        Assert.notNull(key, "key is not null");
        Assert.notNull(timeout, "timeout is not null");

    }

    public void bRPopLPush(String source, String destination, Long timeout){
        Assert.notNull(source, "source is not null");
        Assert.notNull(destination, "destination is not null");
        Assert.notNull(timeout, "timeout is not null");

    }

    public String lIndex(String key, Integer index){
        Assert.notNull(key, "key is not null");
        Assert.notNull(index, "index is not null");

        Node node = holder.get(key);
        if (node == null) {
            return "";
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return null;
        }
        return ((ListNode)node).get(index);
    }

    public boolean lInsert(String key, String location, Integer pivot, String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(location, "location is not null");
        Assert.notNull(pivot, "pivot is not null");
        Assert.notNull(value, "value is not null");

        Node node = holder.get(key);
        if (node == null) {
            LinkedList<String> list = new LinkedList<>();
            list.addFirst(value);
            node = new ListNode(key, list);
            holder.put(key, node);
        }else {
            if (!NodeTypeEnum.LIST.equals(node.type())) {
                return false;
            }
            if ("BEFORE".equals(location)) {
                ((ListNode)node).insert(pivot, value);
            }else {
                ((ListNode)node).insert(pivot + 1, value);
            }
        }
        return true;
    }

    public int lLen(String key){
        Assert.notNull(key, "key is not null");

        Node node = holder.get(key);
        if (node == null) {
            return 0;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return 0;
        }
        return ((ListNode)node).get().size();
    }

    public String lPop(String key){
        Assert.notNull(key, "key is not null");

        Node node = holder.get(key);
        if (node == null) {
            return "";
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return "";
        }
        return ((ListNode)node).popFirst();
    }

    public boolean lPush(String key,List<String> values){
        Assert.notNull(key, "key is not null");
        Assert.notNull(values, "values is not null");

        Node node = holder.get(key);
        if (node == null) {
            LinkedList<String> list = new LinkedList<>();
            ListNode listNode = new ListNode(key, list);
            node = listNode;
            holder.put(key, node);
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return false;
        }

        for (String value : values) {
            ((ListNode)node).pushFirst(value);
        }
        return true;
    }

    public boolean lPushX(String key, String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        Node node = holder.get(key);
        if (node == null) {
            return false;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return false;
        }
        ((ListNode)node).pushFirst(value);
        return true;
    }

    public List<String> lRange(String key, Integer start, Integer stop){
        Assert.notNull(key, "key is not null");
        Assert.notNull(start, "start is not null");
        Assert.notNull(stop, "stop is not null");


        Node node = holder.get(key);
        if (node == null) {
            return null;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return null;
        }
        List<String> res = new ArrayList<>();
        for (int i = start; i <= stop; i++) {
            res.add(((ListNode)node).get(i));
        }
        return res;
    }

    public boolean lRem( String key, Integer count,String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(count, "count is not null");
        Assert.notNull(value, "value is not null");

        Node node = holder.get(key);
        if (node == null) {
            return false;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return false;
        }

        List<String> list = ((ListNode)node).get();
        while (count > 0) {
            if (!list.remove(value)) {
                break;
            }
            count --;
        }
        return true;
    }

    public boolean lSet(String key,Integer index, String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(index, "index is not null");
        Assert.notNull(value, "value is not null");

        Node node = holder.get(key);
        if (node == null) {
            return false;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return false;
        }

        ((ListNode)node).set(index, value);
        return true;
    }

    public void lTrim( String key,Integer start, Integer stop){
        Assert.notNull(key, "key is not null");
        Assert.notNull(start, "start is not null");
        Assert.notNull(stop, "stop is not null");

    }

    public String rPop(String key){
        Assert.notNull(key, "key is not null");

        Node node = holder.get(key);
        if (node == null) {
            return "";
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return "";
        }
        return ((ListNode)node).popLast();
    }

    public boolean rPopLPush( String source, String destination, Long timeout){
        Assert.notNull(source, "source is not null");
        Assert.notNull(destination, "destination is not null");
        Assert.notNull(timeout, "timeout is not null");

        Node popNode = holder.get(source);
        if (popNode == null) {
            return false;
        }
        if (!NodeTypeEnum.LIST.equals(popNode.type())) {
            return false;
        }

        String val = ((ListNode) popNode).popLast();

        Node pushNode = holder.get(destination);
        if (pushNode == null) {
            LinkedList<String> list = new LinkedList<>();
            list.add(val);
            ListNode listNode = new ListNode(destination, list);
            holder.put(destination, listNode);
        }else {
            if (!NodeTypeEnum.LIST.equals(pushNode.type())) {
                return false;
            }
            ((ListNode) popNode).pushFirst(val);
        }
        return true;
    }

    public boolean rPush( String key, List<String> values){
        Assert.notNull(key, "key is not null");
        Assert.notNull(values, "values is not null");

        Node node = holder.get(key);
        if (node == null) {
            LinkedList<String> list = new LinkedList<>(values);
            ListNode listNode = new ListNode(key, list);
            holder.put(key, listNode);
            return true;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return false;
        }
        for (String val : values) {
            ((ListNode)node).pushLast(val);
        }
        return true;

    }

    public boolean rPushX( String key, String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        Node node = holder.get(key);
        if (node == null) {
            return false;
        }
        if (!NodeTypeEnum.LIST.equals(node.type())) {
            return false;
        }
        return ((ListNode)node).pushLast(value);
    }

}
