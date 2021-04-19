package com.echi.redisj.dao;

/**
 * @author chengxiaoxiao
 * @date 2021/4/9 10:27 上午
 */
public interface Node<T> {
    T get();
    boolean set();
    boolean expire(long seconds);
    Class<T> type();
    long ttl();
    boolean presist();
}
