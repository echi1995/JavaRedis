package com.echi.redisj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/9 2:51 下午
 */
@RestController
public class ListController {


    /**
     * 移出并获取列表的第一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     * @param key
     * @param timeout
     * @return
     */
    @GetMapping("/bLPop")
    public ResponseEntity bLPop(@RequestParam("key") String key, @RequestParam("timeout") Long timeout){
        Assert.notNull(key, "key is not null");
        Assert.notNull(timeout, "timeout is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 移出并获取列表的最后一个元素， 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     * @param key
     * @param timeout
     * @return
     */
    @GetMapping("/bRPop")
    public ResponseEntity bRPop(@RequestParam("key") String key, @RequestParam("timeout") Long timeout){
        Assert.notNull(key, "key is not null");
        Assert.notNull(timeout, "timeout is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 从列表中弹出一个值，将弹出的元素插入到另外一个列表中并返回它； 如果列表没有元素会阻塞列表直到等待超时或发现可弹出元素为止。
     * @param source
     * @param destination
     * @param timeout
     * @return
     */
    @GetMapping("/bRPopLPush")
    public ResponseEntity bRPopLPush(@RequestParam("source") String source, @RequestParam("destination") String destination, @RequestParam("timeout") Long timeout){
        Assert.notNull(source, "source is not null");
        Assert.notNull(destination, "destination is not null");
        Assert.notNull(timeout, "timeout is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 通过索引获取列表中的元素
     * @param key
     * @param index
     * @return
     */
    @GetMapping("/lIndex")
    public ResponseEntity lIndex(@RequestParam("key") String key, @RequestParam("index") Integer index){
        Assert.notNull(key, "key is not null");
        Assert.notNull(index, "index is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 在列表的元素前或者后插入元素
     * @param key
     * @param location
     * @param pivot
     * @param value
     * @return
     */
    @GetMapping("/lInsert")
    public ResponseEntity lInsert(@RequestParam("key") String key, @RequestParam("location") String location, @RequestParam("pivot") String pivot, @RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(location, "location is not null");
        Assert.notNull(pivot, "pivot is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取列表长度
     * @param key
     * @return
     */
    @GetMapping("/lLen")
    public ResponseEntity lLen(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 移出并获取列表的第一个元素
     * @param key
     * @return
     */
    @GetMapping("/lPop")
    public ResponseEntity lPop(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将一个或多个值插入到列表头部
     * @param key
     * @param values
     * @return
     */
    @PostMapping("/lPush")
    public ResponseEntity lPush(@RequestParam("key") String key,@RequestBody List<String> values){
        Assert.notNull(key, "key is not null");
        Assert.notNull(values, "values is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将一个值插入到已存在的列表头部
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/lPushX")
    public ResponseEntity lPushX(@RequestParam("key") String key,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取列表指定范围内的元素
     * @param key
     * @param start
     * @param stop
     * @return
     */
    @GetMapping("/lRange")
    public ResponseEntity lRange(@RequestParam("key") String key,@RequestParam("start") Integer start,@RequestParam("stop") Integer stop){
        Assert.notNull(key, "key is not null");
        Assert.notNull(start, "start is not null");
        Assert.notNull(stop, "stop is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 移除列表元素
     * Redis Lrem 根据参数 COUNT 的值，移除列表中与参数 VALUE 相等的元素。
     *
     * COUNT 的值可以是以下几种：
     *
     * count > 0 : 从表头开始向表尾搜索，移除与 VALUE 相等的元素，数量为 COUNT 。
     * count < 0 : 从表尾开始向表头搜索，移除与 VALUE 相等的元素，数量为 COUNT 的绝对值。
     * count = 0 : 移除表中所有与 VALUE 相等的值。
     * @param key
     * @param count
     * @param value
     * @return
     */
    @GetMapping("/lRem")
    public ResponseEntity lRem(@RequestParam("key") String key,@RequestParam("count") Integer count,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(count, "count is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 通过索引设置列表元素的值
     * @param key
     * @param index
     * @param value
     * @return
     */
    @GetMapping("/lSet")
    public ResponseEntity lSet(@RequestParam("key") String key,@RequestParam("index") Integer index,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(index, "index is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 对一个列表进行修剪(trim)，就是说，让列表只保留指定区间内的元素，不在指定区间之内的元素都将被删除。
     * @param key
     * @param start
     * @param stop
     * @return
     */
    @GetMapping("/lTrim")
    public ResponseEntity lTrim(@RequestParam("key") String key,@RequestParam("start") Integer start,@RequestParam("stop") Integer stop){
        Assert.notNull(key, "key is not null");
        Assert.notNull(start, "start is not null");
        Assert.notNull(stop, "stop is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 移除列表的最后一个元素，返回值为移除的元素。
     * @param key
     * @return
     */
    @GetMapping("/rPop")
    public ResponseEntity rPop(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 移除列表的最后一个元素，并将该元素添加到另一个列表并返回
     * @param source
     * @param destination
     * @param timeout
     * @return
     */
    @GetMapping("/rPopLPush")
    public ResponseEntity rPopLPush(@RequestParam("source") String source, @RequestParam("destination") String destination, @RequestParam("timeout") Long timeout){
        Assert.notNull(source, "source is not null");
        Assert.notNull(destination, "destination is not null");
        Assert.notNull(timeout, "timeout is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 在列表中添加一个或多个值
     * @param key
     * @param values
     * @return
     */
    @PostMapping("/rPush")
    public ResponseEntity rPush(@RequestParam("key") String key, @RequestBody List<String> values){
        Assert.notNull(key, "key is not null");
        Assert.notNull(values, "values is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 为已存在的列表添加值
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/rPushX")
    public ResponseEntity rPushX(@RequestParam("key") String key, @RequestParam String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");
        return ResponseEntity.ok("OK");
    }



}
