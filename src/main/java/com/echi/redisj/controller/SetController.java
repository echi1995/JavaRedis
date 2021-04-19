package com.echi.redisj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author chengxiaoxiao
 * @date 2021/4/9 3:32 下午
 */
@RestController
public class SetController {


    /**
     * 向集合添加一个或多个成员
     * @param key
     * @param values
     * @return
     */
    @PostMapping("/sAdd")
    public ResponseEntity sAdd(@RequestParam("key") String key, @RequestBody List<String> values){
        Assert.notNull(key, "key is not null");
        Assert.notNull(values, "value is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 获取集合的成员数
     * @param key
     * @return
     */
    @GetMapping("/sCard")
    public ResponseEntity sCard(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回第一个集合与其他集合之间的差异。
     * @param key
     * @param keys
     * @return
     */
    @PostMapping("/sDiff")
    public ResponseEntity sDiff(@RequestParam("key") String key, @RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");
        Assert.notNull(keys, "keys is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回给定所有集合的差集并存储在 destination 中
     * @param destination
     * @param key
     * @param keys
     * @return
     */
    @PostMapping("/sDiffStore")
    public ResponseEntity sDiffStore(@RequestParam("destination") String destination,@RequestParam("key") String key, @RequestBody List<String> keys){
        Assert.notNull(destination, "destination is not null");
        Assert.notNull(key, "key is not null");
        Assert.notNull(keys, "keys is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回给定所有集合的交集
     * @param key
     * @param keys
     * @return
     */
    @PostMapping("/sInter")
    public ResponseEntity sInter(@RequestParam("key") String key, @RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");
        Assert.notNull(keys, "keys is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回给定所有集合的交集并存储在 destination 中
     * @param destination
     * @param key
     * @param keys
     * @return
     */
    @PostMapping("/sInterStore")
    public ResponseEntity sInterStore(@RequestParam("destination") String destination,@RequestParam("key") String key, @RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");
        Assert.notNull(keys, "keys is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 判断 member 元素是否是集合 key 的成员
     * @param key
     * @param member
     * @return
     */
    @GetMapping("/sIsMember")
    public ResponseEntity sIsMember(@RequestParam("key") String key, @RequestParam String member){
        Assert.notNull(key, "key is not null");
        Assert.notNull(member, "member is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回集合中的所有成员
     * @param key
     * @return
     */
    @GetMapping("/sMembers")
    public ResponseEntity sMembers(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 将 member 元素从 source 集合移动到 destination 集合
     * @param source
     * @param destination
     * @param member
     * @return
     */
    @GetMapping("/sMove")
    public ResponseEntity sMove(@RequestParam("source") String source,@RequestParam("destination") String destination,@RequestParam("member") String member){
        Assert.notNull(source, "source is not null");
        Assert.notNull(destination, "destination is not null");
        Assert.notNull(member, "member is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 移除并返回集合中的一个随机元素
     * @param key
     * @return
     */
    @GetMapping("/sPop")
    public ResponseEntity sPop(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回集合中一个或多个随机数
     * @param key
     * @param count
     * @return
     */
    @GetMapping("/sRandomMember")
    public ResponseEntity sRandomMember(@RequestParam("key") String key,@RequestParam(value = "key", defaultValue = "1") Integer count){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 移除集合中一个或多个成员
     * @param key
     * @param members
     * @return
     */
    @PostMapping("/sRem")
    public ResponseEntity sRem(@RequestParam("key") String key,@RequestBody List<String> members){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 返回所有给定集合的并集
     * @param key
     * @param keys
     * @return
     */
    @PostMapping("/sUnion")
    public ResponseEntity sUnion(@RequestParam("key") String key,@RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }

    /**
     * 所有给定集合的并集存储在 destination 集合中
     * @param destination
     * @param key
     * @param keys
     * @return
     */
    @PostMapping("/sUnionStore")
    public ResponseEntity sUnionStore(@RequestParam("destination") String destination, @RequestParam("key") String key,@RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");
        return ResponseEntity.ok("OK");
    }



}
