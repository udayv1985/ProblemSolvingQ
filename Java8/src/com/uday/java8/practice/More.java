package com.uday.java8.practice;

import java.util.*;
import java.util.stream.Collectors;

public class More {

    public static void main(String[] args) {
        Map<String, String> out = new HashMap<>();
        Map<String, String> map = new HashMap<>();
        map.put("abc", "abc");
        map.put("def", "def");
        map.put("123", "123");
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (Arrays.asList("abc", "def", "ghi").contains(entry.getKey()))
                continue;
            out.put(entry.getKey(), entry.getValue());
        }

        Map<String, String> noi = map.entrySet().stream().filter(e -> !Arrays.asList("abc", "def", "ghi").
                contains(e.getKey())).collect(Collectors.toMap(e -> e.getKey(),e -> e.getValue()));

        System.out.println(noi.toString());

    }
}
