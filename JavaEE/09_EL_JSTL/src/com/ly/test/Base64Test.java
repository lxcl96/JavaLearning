package com.ly.test;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

/**
 * @Author : Ly
 * @Date : 2022/4/29
 * @Description : 测试base64编码
 */
public class Base64Test {
    public static void main(String[] args) {
        Base64.Encoder encoder = Base64.getEncoder();
        byte[] encode = encoder.encode("你好坏，我好喜欢！".getBytes(StandardCharsets.UTF_8));
        String encode1 = encoder.encodeToString("你好坏，我好喜欢！".getBytes(StandardCharsets.UTF_8));
        for (int i = 0; i < encode.length; i++) {
            System.out.print((char)encode[i]);
        }


        System.out.println("\n" + encode1);
    }
}
