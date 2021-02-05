package ch.wh.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Util {

    public static String md5(String source) {
        // 1. 判断source是否有效
        if (source == null || source.isEmpty()) {
            throw new RuntimeException();
        }
        // 2.获取MessageDiges对象
        String algorithm = "md5";
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(algorithm);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        // 3.获取明文的字符串数组
        byte[] input = source.getBytes();
        // 4. 执行加密
        byte[] output = messageDigest.digest(input);

        return toHexString(output);
    }

    private static String toHexString(byte[] digest) {
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
