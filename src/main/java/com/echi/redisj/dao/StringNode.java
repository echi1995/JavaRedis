package com.echi.redisj.dao;

import com.echi.redisj.common.NodeTypeEnum;

/**
 * @author chengxiaoxiao
 * @date 2021/4/19 11:50 上午
 */
public class StringNode extends BaseNode<String> {

    String key;
    char[] value;

    public StringNode(String key, char[] value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public String get() {
        return new String(value);
    }

    @Override
    public boolean set(String s) {
        value = s.toCharArray();
        return true;
    }

    @Override
    public NodeTypeEnum type() {
        return NodeTypeEnum.STRING;
    }

    @Override
    public void removeThis() {
        NodeHolder holder = NodeHolderFactory.holder;
        holder.remove(key);
    }

    public int getBit(int offset){
        if (offset >= value.length * 8) {
            return 0;
        }
        char ch = value[offset / 8];
        int bit = 7 - offset % 8;
        return ch & (1 << bit);
    }

    public boolean setBit(int offset, int target){
        if (offset >= value.length * 8) {
            return false;
        }
        char ch = value[offset / 8];
        int bit = 7 - offset % 8;
        // 将某位置0
        if (target == 0) {
            ch &= 1<<bit;
        }else {
            // 将某位置1
            ch |= 1<<bit;
        }
        value[offset / 8] = ch;
        return true;
    }
}
