package com.learning.interview.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test {
    public static void main(String[] args)
    {

        Scanner sc = new Scanner(System.in);
        String password=sc.next();
        System.out.println(checkPassword(password));;
        //Write your code here
    }

    public static int checkPassword(String password){
        int result=-1;
        boolean isPwdStrong=true;
        int upperCaseCount=0,lowerCaseCount=0;
        char[] pwdArr=password.toCharArray();
        if(pwdArr.length<6){
            return 6- pwdArr.length;
        }
        if(pwdArr.length>20){
            return -1;
        }

        Map<Character,Integer> map=new HashMap<>();

        for(char c:pwdArr){
            if(Character.isUpperCase(c)){
                upperCaseCount++;
            }

            if(Character.isLowerCase(c)){
                lowerCaseCount++;
            }
            if(map.containsKey(c)){
                map.put(c,map.get(c)+1);
            }
            else{
                map.put(c,1);
            }
        }

        for(Character k: map.keySet()){

            if(map.get(k)>1){
                isPwdStrong=false;
            }
        }

        return isPwdStrong && upperCaseCount>0 && lowerCaseCount>0?0:-1;
    }
}
