package com.zhaozheng.utils;


import com.zhaozheng.exception.BusinessException;

import java.security.MessageDigest;
import java.util.UUID;

/**
 * 生成token
 *
 * @author 张胜强
 */
public class TokenGenerator {

    public static String generateValue() {
        return generateValue(UUID.randomUUID().toString());
    }

    private static final char[] HEX_CODE = "0123456789abcdef".toCharArray();

    public static String toHexString(byte[] data) {
        if (data == null) {
            return null;
        }
        StringBuilder r = new StringBuilder(data.length * 2);
        for (byte b : data) {
            r.append(HEX_CODE[(b >> 4) & 0xF]);
            r.append(HEX_CODE[(b & 0xF)]);
        }
        return r.toString();
    }

    public static String generateValue(String param) {
        try {
            // MessageDigest 类为应用程序提供信息摘要算法的功能，如 MD5 或 SHA 算法。
            // 信息摘要是安全的单向哈希函数，它接收任意大小的数据，输出固定长度的哈希值。

            // 1.获取MessageDigest对象
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            // 重置摘要
            algorithm.reset();
            // 2.处理数据,执行加密操作
            algorithm.update(param.getBytes());
            // 3.完成哈希计算，得到的目标字节数组的特点：长度固定为16
            byte[] messageDigest = algorithm.digest();
            return toHexString(messageDigest);
        } catch (Exception e) {
            throw new BusinessException("生成Token失败", e);
        }
    }
}
