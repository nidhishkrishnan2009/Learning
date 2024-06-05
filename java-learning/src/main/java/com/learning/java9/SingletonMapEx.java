package com.learning.java9;

import com.learning.java9.util.CommonUtil;

import java.util.Collections;
import java.util.Map;

public class SingletonMapEx {
    public static void main(String[] args) {
        Map<String,String> singletonMap= Collections.singletonMap("key1","value1");
        try{
            singletonMap.put("key2","value2");
        }
        catch (Exception e){
            System.out.println(e);
        }
        System.out.println(singletonMap);
    }
}
