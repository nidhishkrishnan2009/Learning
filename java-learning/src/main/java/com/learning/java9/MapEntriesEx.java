package com.learning.java9;

import java.util.Map;

public class MapEntriesEx {
    public static void main(String[] args) {
        Map<String, String> map = Map.ofEntries(Map.entry("key1", "value1"), Map.entry("key2", "value2"));
        try{
            map.put("key3","value3");
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(map);
    }
}
