package com.learning.interview.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Basic {
    public static void main(String[] args) {
        String patternStr="Nidish123";
        String str="Hello World";
        Pattern pattern=Pattern.compile(patternStr);
        Matcher matcher=pattern.matcher("Nidish Krishnan");
        if(matcher.matches()){
            System.out.println(" match");
        }
        if(matcher.find()){
            System.out.println("found");
        }

        boolean isOnlyAlphapet=patternStr.matches("[a-z,A-Z]*[0-9]{1,}");
        System.out.println("isOnlyAlphapet ==>"+isOnlyAlphapet);
        boolean startsWith=str.matches("\bHello");
        System.out.println("startsWith ==>"+startsWith);
        boolean endsWith=str.matches("World$");
        System.out.println("endsWith ==>"+endsWith);
        if(isOnlyAlphapet){
            System.out.println("Only Alphabet");
        }

        String whiteSpace=" ";
        char[] whiteSpaceArr=whiteSpace.toCharArray();
        for(char c:whiteSpaceArr){

//            if(Character.isWhitespace(c)){
//                System.out.println("WhiteSPace");
//            }
            int c1=c;
            System.out.println(c1);
            if(c1==11){
                System.out.println("WhiteSPace");
            }
        }
    }
}
