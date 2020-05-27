package com.example.util;

import java.security.MessageDigest;

/**
 * Md5 加密方式
 */
public class Md5Util {

    public static String create32Md5(String word) {
        StringBuilder hexString = null;
        byte[] defaultBytes = word.getBytes();
        try {
            MessageDigest algorithm = MessageDigest.getInstance("MD5");
            byte[] b = algorithm.digest(word.getBytes("utf-8"));
            algorithm.reset();
            algorithm.update(defaultBytes);
            byte messageDigest[] = algorithm.digest();
            hexString = new StringBuilder();
            for (int i = 0; i < messageDigest.length; i++) {
                if (Integer.toHexString(0xFF & messageDigest[i]).length() == 1) {
                    hexString.append(0);
                }
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            }
            messageDigest.toString();
        } catch (Exception e) {
        }
        return hexString.toString();
    }
}
