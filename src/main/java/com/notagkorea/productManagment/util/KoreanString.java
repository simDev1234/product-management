package com.notagkorea.productManagment.util;

import java.nio.charset.StandardCharsets;

public class KoreanString {

    public static String toUTF8String(String plainKoreanString) {
        byte[] bytes = plainKoreanString.getBytes(StandardCharsets.UTF_8);
        return new String(bytes, StandardCharsets.UTF_8);
    }

}
