package com.echi.redisj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author chengxiaoxiao
 * @date 2021/4/19 11:20 上午
 */
@RestController("/zSet")
public class ZSetController {


    /**
     *
     * @param key
     * @return
     */
    @PostMapping("/zAdd")
    public ResponseEntity zAdd(@RequestParam("key") String key, @RequestBody Map<String, String> map){
        Assert.notNull(key, "key is not null");
        Assert.notNull(map, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zCard")
    public ResponseEntity zCard(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zCount")
    public ResponseEntity zCount(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zIncrBy")
    public ResponseEntity zIncrBy(@RequestParam("key") String key,@RequestParam("increment") Integer increment,@RequestParam("String") Integer member){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @PostMapping("/zInterStore")
    public ResponseEntity zInterStore(@RequestParam("key") String key,@RequestParam("destination") String destination,@RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zLexCount")
    public ResponseEntity zLexCount(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRange")
    public ResponseEntity zRange(@RequestParam("key") String key,@RequestParam("start") Integer start,@RequestParam("stop") Integer stop){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRangeLex")
    public ResponseEntity zRangeLex(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRangeByScore")
    public ResponseEntity zRangeByScore(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRank")
    public ResponseEntity zRank(@RequestParam("key") String key,@RequestParam("member") String member){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @PostMapping("/zRem")
    public ResponseEntity zRem(@RequestParam("key") String key,@RequestBody List<String> members){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRemRangeByLex")
    public ResponseEntity zRemRangeByLex(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRemRangeByRank")
    public ResponseEntity zRemRangeByRank(@RequestParam("key") String key,@RequestParam("start") Integer start,@RequestParam("stop") Integer stop){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRemRangeByScore")
    public ResponseEntity zRemRangeByScore(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRevRange")
    public ResponseEntity zRevRange(@RequestParam("key") String key,@RequestParam("stop") Integer stop,@RequestParam("start") Integer start){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRevRangeByScore")
    public ResponseEntity zRevRangeByScore(@RequestParam("key") String key,@RequestParam("min") Integer min,@RequestParam("max") Integer max){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zRevRank")
    public ResponseEntity zRevRank(@RequestParam("key") String key,@RequestParam("member") Integer start){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @GetMapping("/zScore")
    public ResponseEntity zScore(@RequestParam("key") String key,@RequestParam("member") Integer start){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     *
     * @param key
     * @return
     */
    @PostMapping("/zUnionStore")
    public ResponseEntity zUnionStore(@RequestParam("key") String key,@RequestParam("destination") String destination, @RequestBody List<String> keys){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }






}
