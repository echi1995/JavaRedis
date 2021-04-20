package com.echi.redisj.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chengxiaoxiao
 * @date 2021/4/8 5:59 下午
 */
@RestController("/key")
public class KeyController {

    /**
     * 设置或更新
     * @param key
     * @param value
     * @return
     */
    @GetMapping("/set")
    public ResponseEntity set(@RequestParam("key") String key, @RequestParam("value") String value){
        Assert.notNull(key, "key is not null");
        Assert.notNull(value, "value is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 删除key
     * @param key
     * @return
     */
    @GetMapping("/del")
    public ResponseEntity del(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 判断是否存在key
     * @param key
     * @return
     */
    @GetMapping("/exists")
    public ResponseEntity exists(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 给key设置过期时间
     * @param key
     * @return
     */
    @GetMapping("/expire")
    public ResponseEntity expire(@RequestParam("key") String key, @RequestParam("seconds") String seconds){
        Assert.notNull(key, "key is not null");
        Assert.notNull(seconds, "seconds is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 查找符合pattern的key
     * @param pattern
     * @return
     */
    @GetMapping("/keys")
    public ResponseEntity keys(@RequestParam("pattern") String pattern){
        Assert.notNull(pattern, "pattern is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 移除过期时间
     * @param key
     * @return
     */
    @GetMapping("/persist")
    public ResponseEntity persist(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * time to live
     * 返回key的剩余过期时间
     * @param key
     * @return
     */
    @GetMapping("/ttl")
    public ResponseEntity ttl(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }

//    /**
//     * 随机返回一个key
//     * @return
//     */
//    @GetMapping("/randomKey")
//    public ResponseEntity randomKey(){
//
//        return ResponseEntity.ok("OK");
//    }

    /**
     * 仅当 newkey 不存在时, 给key重命名
     * @param key
     * @return
     */
    @GetMapping("/rename")
    public ResponseEntity rename(@RequestParam("key") String key, @RequestParam("newKey") String newKey){
        Assert.notNull(key, "key is not null");
        Assert.notNull(newKey, "newKey is not null");

        return ResponseEntity.ok("OK");
    }

    /**
     * 返回key的type
     * @param key
     * @return
     */
    @GetMapping("/type")
    public ResponseEntity type(@RequestParam("key") String key){
        Assert.notNull(key, "key is not null");

        return ResponseEntity.ok("OK");
    }


}
