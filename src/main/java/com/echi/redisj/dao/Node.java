package com.echi.redisj.dao;

import com.echi.redisj.common.NodeTypeEnum;

/**
 * @author chengxiaoxiao
 * @date 2021/4/9 10:27 上午
 */
public interface Node<T> {
    /**
     * 获取值
     * @return
     */
    T get();

    /**
     * 设置新值，会覆盖
     * @param t
     * @return
     */
    boolean set(T t);

    /**
     * 设置过期时间
     * @param seconds
     * @return
     */
    boolean expire(long seconds);

    /**
     * 获取类型
     * @return
     */
    NodeTypeEnum type();

    /**
     * 查询还有多久存活，单位毫秒
     * @return
     */
    long ttl();

    /**
     * 持久化
     * 如果已经过期，会被删除
     * 如果未过期，去除过期时间
     * @return
     */
    boolean presist();

    /**
     * 移除本身
     */
    void removeThis();
}
