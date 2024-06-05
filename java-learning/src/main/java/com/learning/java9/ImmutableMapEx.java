package com.learning.java9;

import java.util.Collections;
import java.util.Map;

public class ImmutableMapEx {
    public static void main(String[] args) {
        Map<String, String> map = Map.of("key1", "value1", "key2", "value2");
        Map<String,String> unModifiableMap=Collections.unmodifiableMap(map);
        try {
            System.out.println("un modifiable map before modify");
            System.out.println(unModifiableMap);
            System.out.println("un modifiable map after modify");
            unModifiableMap.put("key3","value3");
            System.out.println(unModifiableMap);
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
