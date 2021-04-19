package com.echi.redisj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/8 6:11 下午
 */
@RestController("/string")
public class StringController {


//    /**
//     * 设置或更新
//     * @param key
//     * @param value
//     * @return
//     */
//    @GetMapping("/set")
//    public ResponseEntity set(@RequestParam("key") String key, @RequestParam("value") String value){
//        Assert.notNull(key, "key is not null");
//        Assert.notNull(value, "value is not null");
//
//        return ResponseEntity.ok("OK");
//    }

    /**
     * 获取指定 key 的值。
     * @param key
     * @return
     */
    @GetMapping("/get")
    public ResponseEntity get(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 返回 key 中字符串值的子字符
     * @param key
     * @param start
     * @param end
     * @return
     */
    @GetMapping("/getRange")
    public ResponseEntity getRange(@RequestParam("key") String key, @RequestParam("start") Integer start, @RequestParam("end") Integer end){
        Assert.notNull(key, "key is not null");
        Assert.notNull(start, "start is not null");
        Assert.notNull(end, "end is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将给定 key 的值设为 value ，并返回 key 的旧值(old value)。
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/getSet")
    public ResponseEntity getSet(@RequestParam("key") String key, @RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 对 key 所储存的字符串值，获取指定偏移量上的位(bit)。
     * @param key
     * @param offset
     * @return
     */
    @GetMapping("/getBit")
    public ResponseEntity getBit(@RequestParam("key") String key, @RequestParam("offset") Integer offset){
        Assert.notNull(key, "key is not null");
        Assert.notNull(offset, "offset is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取所有(一个或多个)给定 key 的值。
     * @param keys
     * @return
     */
    @PostMapping("/mGet")
    public ResponseEntity mGet(@RequestBody List<String> keys){
        Assert.notNull(keys, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 对 key 所储存的字符串值，设置或清除指定偏移量上的位(bit)。
     * @param key
     * @param offset
     * @param value
     * @return
     */
    @GetMapping("/setBit")
    public ResponseEntity setBit(@RequestParam("key") String key,@RequestParam("offset") String offset,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(offset, "offset is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将值 value 关联到 key ，并将 key 的过期时间设为 seconds (以秒为单位)。
     * @param key
     * @param second
     * @param value
     * @return
     */
    @GetMapping("/setEx")
    public ResponseEntity setEx(@RequestParam("key") String key,@RequestParam("second") String second,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(second, "second is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 只有在 key 不存在时设置 key 的值。
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/setNx")
    public ResponseEntity setNx(@RequestParam("key") String key,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 用 value 参数覆写给定 key 所储存的字符串值，从偏移量 offset 开始。
     * @param key
     * @param offset
     * @param value
     * @return
     */
    @GetMapping("/setRange")
    public ResponseEntity setRange(@RequestParam("key") String key,@RequestParam("offset") String offset,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(offset, "offset is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 返回 key 所储存的字符串值的长度。
     * @param key
     * @return
     */
    @GetMapping("/strLen")
    public ResponseEntity strLen(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 同时设置一个或多个 key-value 对。
     * @param keys
     * @return
     */
    @PostMapping("/mSet")
    public ResponseEntity mSet(@RequestBody List<String[]> keys){
        Assert.notNull(keys, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 同时设置一个或多个 key-value 对，当且仅当所有给定 key 都不存在。
     * @param keys
     * @return
     */
    @PostMapping("/mSetNX")
    public ResponseEntity mSetNX(@RequestBody List<String[]> keys){
        Assert.notNull(keys, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将 key 中储存的数字值增一。
     * @param key
     * @return
     */
    @GetMapping("/incr")
    public ResponseEntity incr(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将 key 所储存的值加上给定的增量值（increment） 。
     * @param key
     * @param increment
     * @return
     */
    @GetMapping("/incrBy")
    public ResponseEntity incrBy(@RequestParam("key") String key,@RequestParam("increment") Integer increment){
        Assert.notNull(key, "key is not null");
        Assert.notNull(increment, "increment is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将 key 中储存的数字值减一。
     * @param key
     * @return
     */
    @GetMapping("/decr")
    public ResponseEntity decr(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * key 所储存的值减去给定的减量值（decrement） 。
     * @param key
     * @param increment
     * @return
     */
    @GetMapping("/decrBy")
    public ResponseEntity decrBy(@RequestParam("key") String key,@RequestParam("increment") Integer increment){
        Assert.notNull(key, "key is not null");
        Assert.notNull(increment, "increment is not null");
        StringBuilder stringBuilder = new StringBuilder();
        return ResponseEntity.ok("OK");
    }

    /**
     * 如果 key 已经存在并且是一个字符串， APPEND 命令将指定的 value 追加到该 key 原来值（value）的末尾。
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/append")
    public ResponseEntity append(@RequestParam("key") String key,@RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }




}
