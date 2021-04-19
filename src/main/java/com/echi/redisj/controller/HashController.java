package com.echi.redisj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/9 11:07 上午
 */
@RestController("/hash")
public class HashController {


    /**
     * 删除一个或多个哈希表字段
     * @param key
     * @param fields
     * @return
     */
    @PostMapping("/hDel")
    public ResponseEntity hDel(@RequestParam("key") String key, @RequestBody List<String> fields){
        Assert.notNull(key, "key is not null");
        Assert.notNull(fields, "fields is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 查看哈希表 key 中，指定的字段是否存在。
     * @param key
     * @param field
     * @return
     */
    @GetMapping("/hExists")
    public ResponseEntity hExists(@RequestParam("key") String key, @RequestParam("field") String field){
        Assert.notNull(key, "key is not null");
        Assert.notNull(field, "field is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取存储在哈希表中指定字段的值。
     * @param key
     * @param field
     * @return
     */
    @GetMapping("/hGet")
    public ResponseEntity hGet(@RequestParam("key") String key, @RequestParam("field") String field){
        Assert.notNull(key, "key is not null");
        Assert.notNull(field, "field is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取在哈希表中指定 key 的所有字段和值
     * @param key
     * @return
     */
    @GetMapping("/hGetAll")
    public ResponseEntity hGetAll(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 为哈希表 key 中的指定字段的整数值加上增量 increment 。
     * @param key
     * @param field
     * @param increment
     * @return
     */
    @GetMapping("/hIncrBy")
    public ResponseEntity hGet(@RequestParam("key") String key, @RequestParam("field") String field, @RequestParam("increment") String increment){
        Assert.notNull(key, "key is not null");
        Assert.notNull(field, "field is not null");
        Assert.notNull(increment, "increment is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取所有哈希表中的字段
     * @param key
     * @return
     */
    @GetMapping("/hKeys")
    public ResponseEntity hKeys(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取哈希表中字段的数量
     * @param key
     * @return
     */
    @GetMapping("/hLen")
    public ResponseEntity hLen(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取所有给定字段的值
     * @param key
     * @param fields
     * @return
     */
    @PostMapping("/hMGet")
    public ResponseEntity hMGet(@RequestParam("key") String key, @RequestBody List<String> fields){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 同时将多个 field-value (域-值)对设置到哈希表 key 中。
     * @param key
     * @param fields
     * @return
     */
    @PostMapping("/hMSet")
    public ResponseEntity hMSet(@RequestParam("key") String key, @RequestBody List<String[]> fields){
        Assert.notNull(key, "key is not null");
        Assert.notNull(fields, "fields is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 将哈希表 key 中的字段 field 的值设为 value 。
     * @param key
     * @param field
     * @param value
     * @return
     */
    @GetMapping("/hSet")
    public ResponseEntity hSet(@RequestParam("key") String key, @RequestParam("field") String field, @RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(field, "field is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 只有在字段 field 不存在时，设置哈希表字段的值。
     * @param key
     * @param field
     * @param value
     * @return
     */
    @GetMapping("/hSetNX")
    public ResponseEntity hSetNX(@RequestParam("key") String key, @RequestParam("field") String field, @RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(field, "field is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 获取哈希表中所有值。
     * @param key
     * @return
     */
    @GetMapping("/hVals")
    public ResponseEntity hVals(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }






}
