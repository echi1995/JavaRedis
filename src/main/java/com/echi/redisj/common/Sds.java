package com.echi.redisj.common;

import java.util.Arrays;

/**
 * @author chengxiaoxiao
 * @date 2021/5/6 11:49 上午
 */
public class Sds {

    private static final Integer SDS_MAX_PREALLOC = 1024 * 1024;

    public SdsHdr sdsHdr = null;

    class SdsHdr {
        public int len;
        public int free;
        public char[] buf;
    }

    static int sdslen(SdsHdr sds) {
        return sds.len;
    }

    static int sdsavail(SdsHdr sds) {
        return sds.free;
    }

    /**
     * 根据给定的初始化字符串 init 和字符串长度 initlen
     * 创建一个新的 sds
     * <p>
     * 参数
     * init ：初始化字符串指针
     * initlen ：初始化字符串的长度
     * <p>
     * 返回值
     * sds ：创建成功返回 sdshdr 相对应的 sds
     * 创建失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdsnewlen(char[] init, int initlen) {
        SdsHdr sh = new SdsHdr();

        sh.len = initlen;
        sh.free = 0;
        char[] buf = Arrays.copyOf(init, initlen);
        sh.buf = buf;
        return sh;
    }

    /**
     * 根据给定字符串 init ，创建一个包含同样字符串的 sds
     * <p>
     * 参数
     * init ：如果输入为 NULL ，那么创建一个空白 sds
     * 否则，新创建的 sds 中包含和 init 内容相同字符串
     * <p>
     * 返回值
     * sds ：创建成功返回 sdshdr 相对应的 sds
     * 创建失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdsnew(char[] init) {
        int initlen = init == null ? 0 : init.length;
        return sdsnewlen(init, initlen);
    }

    /**
     * 创建并返回一个只保存了空字符串 "" 的 sds
     * <p>
     * 返回值
     * sds ：创建成功返回 sdshdr 相对应的 sds
     * 创建失败返回 NULL
     * <p>
     * 复杂度
     * T = O(1)
     */
    SdsHdr sdsempty() {
        return sdsnewlen("".toCharArray(), 0);
    }

    /**
     * 复制给定 sds 的副本
     * <p>
     * 返回值
     * sds ：创建成功返回输入 sds 的副本
     * 创建失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdsdup(SdsHdr sds) {
        return sdsnewlen(sds.buf, sds.len);
    }

    /**
     * 将 sds 扩充至指定长度，未使用的空间以 0 字节填充。
     * <p>
     * 返回值
     * sds ：扩充成功返回新 sds ，失败返回 NULL
     * <p>
     * 复杂度：
     * T = O(N)
     */
    SdsHdr sdsgrowzero(SdsHdr sds, int len) {

        int curLen = sds.len;
        // 如果不需要扩充
        if (curLen >= len) {
            return sds;
        }

        SdsHdr sdsHdr = sdsMakeRoomFor(sds, len - curLen);
        if (sdsHdr == null) {
            return null;
        }
        char[] buf = sdsHdr.buf;
        // 将[cur, len]用0填充
        for (int i = curLen; i < len; i++) {
            buf[i] = 0;
        }

        // 此时的len为len，
        int totalLen = sdsHdr.len + sdsHdr.free;
        sdsHdr.len = len;
        sdsHdr.free = totalLen - len;
        return sdsHdr;
    }

    /**
     * 将长度为 len 的字符串 t 追加到 sds 的字符串末尾
     * <p>
     * 返回值
     * sds ：追加成功返回新 sds ，失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdscatlen(SdsHdr sds, char[] t, int len) {
        int curLen = sdslen(sds);

        SdsHdr sdsHdr = sdsMakeRoomFor(sds, len);
        if (sdsHdr == null) {
            return null;
        }
        char[] buf = sdsHdr.buf;
        for (int i = curLen; i < curLen + len; i++) {
            buf[i] = t[i - curLen];
        }
        sdsHdr.len = curLen + len;
        sdsHdr.free = sds.free - len;

        return sdsHdr;
    }

    /**
     * 将给定字符串 t 追加到 sds 的末尾
     * <p>
     * 返回值
     * sds ：追加成功返回新 sds ，失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdscat(SdsHdr sds, char[] t) {
        return sdscatlen(sds, t, t.length);
    }


    /**
     * 将另一个 sds 追加到一个 sds 的末尾
     * <p>
     * 返回值
     * sds ：追加成功返回新 sds ，失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdscatsds(SdsHdr sds, SdsHdr t) {
        return sdscatlen(sds, t.buf, t.buf.length);
    }

    /**
     * 将字符串 t 的前 len 个字符复制到 sds s 当中，
     * 并在字符串的最后添加终结符。
     * <p>
     * 如果 sds 的长度少于 len 个字符，那么扩展 sds
     * <p>
     * 复杂度
     * T = O(N)
     * <p>
     * 返回值
     * sds ：复制成功返回新的 sds ，否则返回 NULL
     */
    SdsHdr sdscpylen(SdsHdr sds, char[] t, int len) {
        int totalLen = sds.len + sds.free;
        if (totalLen < len) {
            sds = sdsMakeRoomFor(sds, len - sds.len);
            if (sds == null) {
                return null;
            }
            totalLen = sds.len + sds.free;
        }
        char[] buf = sds.buf;
        for (int i = 0; i < len; i++) {
            buf[i] = t[i];
        }
        sds.len = len;
        sds.free = totalLen - len;
        return sds;
    }

    /**
     * 将字符串复制到 sds 当中，
     * 覆盖原有的字符。
     * <p>
     * 如果 sds 的长度少于字符串的长度，那么扩展 sds 。
     * <p>
     * 复杂度
     * T = O(N)
     * <p>
     * 返回值
     * sds ：复制成功返回新的 sds ，否则返回 NULL
     */
    SdsHdr sdscpy(SdsHdr sds, char[] t) {
        return sdscpylen(sds, t, t.length);
    }

    /**
     * 对 sds 左右两端进行修剪，清除其中 cset 指定的所有字符
     * <p>
     * 比如 sdsstrim(xxyyabcyyxy, "xy") 将返回 "abc"
     * <p>
     * 复杂性：
     * T = O(M*N)，M 为 SDS 长度， N 为 cset 长度。
     */
    SdsHdr sdstrim(SdsHdr sds, char[] cset) {
        char[] buf = sds.buf;
        int left = 0;
        int right = buf.length - 1;
        Arrays.sort(cset);
        for (; left < buf.length; left++) {
            if (Arrays.binarySearch(cset, buf[left]) < 0) {
                break;
            }
        }
        for (; right >= 0 && right >= left; right--) {
            if (Arrays.binarySearch(cset, buf[right]) < 0) {
                break;
            }
        }
        int len = (left > right) ? 0 : right - left;
        if (right + 1 - left >= 0) {
            System.arraycopy(buf, left, buf, 0, right + 1 - left);
        }
        sds.free = sds.free + sds.len - left;
        sds.len = len;
        return sds;
    }

    /**
     * 按索引对截取 sds 字符串的其中一段
     * start 和 end 都是闭区间（包含在内）
     * <p>
     * 索引从 0 开始，最大为 sdslen(s) - 1
     * 索引可以是负数， sdslen(s) - 1 == -1
     * <p>
     * 复杂度
     * T = O(N)
     */
    void sdsrange(SdsHdr sds, int start, int end) {
        int len = sdslen(sds);
        if (len == 0) {
            return ;
        }
        if (start < 0) {
            start = len+start;
            if (start < 0) {
                start = 0;
            }
        }
        if (end < 0) {
            end = len+end;
            if (end < 0) {
                end = 0;
            }
        }
        int newLen = start > end ? 0 : end - start + 1;
        if (newLen != 0) {
            if (start >= len) {
                newLen = 0;
            } else if (end >= len) {
                end = len-1;
                newLen = (start > end) ? 0 : (end-start)+1;
            }
        } else {
            start = 0;
        }
        char[] buf = sds.buf;
        if (start != 0 && newLen != 0) {
            System.arraycopy(buf, start, buf, 0, end + 1 - start);
        }
        sds.free = sds.free + sds.len - newLen;
        sds.len = newLen;

    }

    // 未使用函数，可能已废弃
    void sdsupdatelen(Sds sds) {}

    /**
     * 在不释放 SDS 的字符串空间的情况下，
     * 重置 SDS 所保存的字符串为空字符串。
     * <p>
     * 复杂度
     * T = O(1)
     */
    void sdsclear(SdsHdr sds) {
        sds.free += sds.len;
        sds.len = 0;
    }

    /**
     * 对比两个 sds ， strcmp 的 sds 版本
     * <p>
     * 返回值
     * int ：相等返回 0 ，s1 较大返回正数， s2 较大返回负数
     * <p>
     * T = O(N)
     */
    int sdscmp(SdsHdr sds1, SdsHdr sds2) {
        char[] buf1 = sds1.buf;
        char[] buf2 = sds2.buf;

        int len1 = sdslen(sds1);
        int len2 = sdslen(sds2);
        int minLen = Math.min(len1, len2);
        for (int i = 0; i < minLen; i++) {
            if (buf1[i] != buf2[i]) {
                return buf1[i] - buf2[i];
            }
        }
        return len1 - len2;
    }

    /**
     * 释放 tokens 数组中 count 个 sds
     * <p>
     * T = O(N^2)
     */
    void sdsfreesplitres(SdsHdr[] tokens, int count) {
        count = Math.min(count, tokens.length);
        for (int i = 0; i < count; i++) {
            tokens[i] = null;
        }
    }

    /**
     * 将 sds 字符串中的所有字符转换为小写
     * <p>
     * T = O(N)
     */
    void sdstolower(SdsHdr sds) {
        char[] buf = sds.buf;
        for (int i = 0; i < buf.length; i++) {
            buf[i] = Character.toLowerCase(buf[i]);
        }
    }

    /**
     * 将 sds 字符串中的所有字符转换为大写
     * <p>
     * T = O(N)
     */
    void sdstoupper(SdsHdr sds) {
        char[] buf = sds.buf;
        for (int i = 0; i < buf.length; i++) {
            buf[i] = Character.toUpperCase(buf[i]);
        }
    }

    /**
     * 根据输入的 long long 值 value ，创建一个 SDS
     */
    SdsHdr sdsfromlonglong(long value) {
        char[] buf = String.valueOf(value).toCharArray();

        return sdsnewlen(buf, buf.length);
    }

    /**
     * 将长度为 len 的字符串 p 以带引号（quoted）的格式
     * 追加到给定 sds 的末尾
     * <p>
     * T = O(N)
     */
    SdsHdr sdscatrepr(SdsHdr sds, char[] p, int len) {
        sds = sdscatlen(sds, "\"".toCharArray(), 1);
        while(len > 0) {
            len --;
            switch(p[len]) {
                case '\\': sds = sdscatlen(sds,"\\\\".toCharArray(),2);break;
                case '"': sds = sdscatlen(sds,"\"".toCharArray(),1);break;
                case '\n': sds = sdscatlen(sds,"\\n".toCharArray(),2); break;
                case '\r': sds = sdscatlen(sds,"\\r".toCharArray(),2); break;
                case '\t': sds = sdscatlen(sds,"\\t".toCharArray(),2); break;
                case '\b': sds = sdscatlen(sds,"\\b".toCharArray(),2); break;
                default: sds = sdscatlen(sds, new char[]{p[len]}, 1); break;
            }
        }
        sdscatlen(sds, "\"".toCharArray(), 1);
        return sds;
    }

    /**
     *
     * 将字符串 s 中，
     * 所有在 from 中出现的字符，替换成 to 中的字符
     *
     * 比如调用 sdsmapchars(mystring, "ho", "01", 2)
     * 就会将 "hello" 转换为 "0ell1"
     *
     * 因为无须对 sds 进行大小调整，
     * 所以返回的 sds 输入的 sds 一样
     * <p>
     * T = O(N^2)
     */
    SdsHdr sdsmapchars(SdsHdr sds, char[] from, char[] to, int setlen) {
        char[] buf = sds.buf;

        for (int i = 0; i < buf.length; i++) {
            for (int j = 0; j < setlen; j++) {
                if (buf[i] == from[j]) {
                    buf[i] = to[j];
                    break;
                }
            }
        }
        return sds;
    }

    /**
     * Join an array of C strings using the specified separator (also a C string).
     * Returns the result as an sds string.
     */
    SdsHdr sdsjoin(char[][] argv, int argc, char[] sep) {
        SdsHdr join = sdsempty();

        for (int i = 0; i < argc; i++) {
            join = sdscat(join, argv[i]);
            if (i != argc - 1) {
                join = sdscat(join, sep);
            }
        }
        return join;
    }


    /**
     * 对 sds 中 buf 的长度进行扩展，确保在函数执行之后，
     * buf 至少会有 addlen 长度的空余空间
     * <p>
     * 返回值
     * sds ：扩展成功返回扩展后的 sds
     * 扩展失败返回 NULL
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdsMakeRoomFor(SdsHdr sds, int addlen) {
        // 如果空余长度够用，不用扩容
        if (sds.free >= addlen) {
            return sds;
        }
        char[] buf = sds.buf;

        int len = sds.len;
        int newLen = len + addlen;

        if (newLen < SDS_MAX_PREALLOC) {
            newLen *= 2;
        }else {
            newLen += SDS_MAX_PREALLOC;
        }

        char[] newBuf = new char[newLen];
        if (len >= 0) {
            System.arraycopy(buf, 0, newBuf, 0, len);
        }
        sds.buf = newBuf;
        return sds;
    }

    /**
     * 根据 incr 参数，增加 sds 的长度，缩减空余空间，
     * 并将 \0 放到新字符串的尾端
     * <p>
     * 这个函数是在调用 sdsMakeRoomFor() 对字符串进行扩展，
     * 然后用户在字符串尾部写入了某些内容之后，
     * 用来正确更新 free 和 len 属性的。
     * <p>
     * 如果 incr 参数为负数，那么对字符串进行右截断操作。
     * <p>
     * 以下是 sdsIncrLen 的用例：
     * <p>
     * oldlen = sdslen(s);
     * s = sdsMakeRoomFor(s, BUFFER_SIZE);
     * nread = read(fd, s+oldlen, BUFFER_SIZE);
     * ... check for nread <= 0 and handle it ...
     * sdsIncrLen(s, nread);
     * <p>
     * 复杂度
     * T = O(1)
     */
    void sdsIncrLen(SdsHdr sds, int incr) {
        if (sds.free < incr) {
            return;
        }
        sds.free -= incr;
        sds.len += incr;

    }

    /**
     * 回收 sds 中的空闲空间，
     * 回收不会对 sds 中保存的字符串内容做任何修改。
     * <p>
     * 返回值
     * sds ：内存调整后的 sds
     * <p>
     * 复杂度
     * T = O(N)
     */
    SdsHdr sdsRemoveFreeSpace(SdsHdr sds) {
        char[] newBuf = new char[sds.len];
        System.arraycopy(sds.buf, 0, newBuf, 0, sds.len);
        sds.buf = newBuf;
        sds.free = 0;
        return sds;
    }

    /**
     * 返回给定 sds 分配的内存字节数
     * <p>
     * 复杂度
     * T = O(1)
     */
    int sdsAllocSize(SdsHdr sds) {
        return sds.len + sds.free;
    }


}
