package com.vinit.example.practice;

import java.util.Base64;

public class EncoderDecoder {
    public static void main(String[] args) {
        String url = "www.google.com";
        System.out.println(encode(url));
        String eurl = encode(url);
        System.out.println(decode(eurl));

    }

    public static String encode(String longUrl) {
        return "www.a.com/" + Base64.getUrlEncoder().encodeToString(longUrl.getBytes());
    }

    public static String decode(String shortUrl) {
        return new String(Base64.getUrlDecoder().decode(shortUrl.substring(10)));
    }
}
