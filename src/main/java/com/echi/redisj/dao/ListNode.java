package com.echi.redisj.dao;

import com.echi.redisj.common.NodeTypeEnum;

import java.util.LinkedList;
import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/21 5:09 下午
 */
public class ListNode extends BaseNode<LinkedList> {


    String key;
    LinkedList<String> list;

    public ListNode(String key, LinkedList<String> list) {
        this.key = key;
        this.list = list;
    }

    @Override
    public LinkedList get() {
        return list;
    }

    @Override
    public boolean set(LinkedList list) {
        list = list;
        return true;
    }

    @Override
    public NodeTypeEnum type() {
        return NodeTypeEnum.LIST;
    }

    @Override
    public void removeThis() {
        NodeHolderFactory.holder.remove(key);
    }

    public String get(int index) {
        return list.get(index);
    }

    public boolean add(String value) {
        list.add(value);
        return true;
    }

    public boolean insert(int index, String value) {
        list.add(index, value);
        return true;
    }

    public String popFirst() {
        return list.pollFirst();
    }

    public String popLast() {
        return list.pollLast();
    }

    public boolean pushFirst(String value) {
        list.addFirst(value);
        return true;
    }

    public boolean pushLast(String value) {
        list.addLast(value);
        return true;
    }

    public boolean set(int index, String value) {
        list.set(index, value);
        return true;
    }

}
