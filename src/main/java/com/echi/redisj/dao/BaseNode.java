package com.echi.redisj.dao;

/**
 * @author chengxiaoxiao
 * @date 2021/4/9 10:31 上午
 */
public abstract class BaseNode<T> implements Node<T>{

    NodeHolder holder;
    Long exprieTime = -1L;

    @Override
    public boolean expire(long seconds) {
        try {
            this.exprieTime = System.currentTimeMillis() + seconds * 1000;
            return true;
        }catch (Exception e) {
            return false;
        }
    }

    @Override
    public long ttl() {
        try {
            return exprieTime - System.currentTimeMillis();
        }catch (Exception e) {
            return -1;
        }
    }

    @Override
    public boolean presist() {
        try {
            if (exprieTime != -1 && exprieTime < System.currentTimeMillis()) {
                return false;
            }
            exprieTime = -1L;
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
