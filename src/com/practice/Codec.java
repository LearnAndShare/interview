package com.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Codec {
    Map<UUID,String> urlShortDecodeMap = new HashMap<>();
    Map<String,UUID> urlEncodeMap = new HashMap<>();
    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        UUID u = UUID.randomUUID();
        urlEncodeMap.putIfAbsent(longUrl,u);
        urlShortDecodeMap.putIfAbsent(u,longUrl);
        return urlEncodeMap.get(longUrl).toString();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return urlShortDecodeMap.get(UUID.fromString(shortUrl));
    }


    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.decode(codec.encode("https://leetcode.com/problems/design-tinyurl")));
    }
}
