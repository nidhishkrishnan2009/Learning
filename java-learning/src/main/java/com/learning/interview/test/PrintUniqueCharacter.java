package com.learning.interview.test;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Scanner;

public class PrintUniqueCharacter {
    public static void main(String args[]) {
        // Your code goes here
//        Scanner scn = new Scanner(System.in);
//        String str = scn.nextLine();

        String str = "abefgbaaklmpq";

        HashSet<Character> unique = new HashSet<>();

        for(int i=0;i<str.length();i++) {
            char ch = str.charAt(i);
            if(unique.contains(ch) == true) {
                //this character has already occured
                unique.remove(ch);
            } else {
                unique.add(ch);
            }
        }

        if(unique.size() == 0) {
            System.out.println("There are no unique characters");
        }

        for(Character ch : unique) {
            System.out.print(ch + "  ");
        }

        System.out.println(new BigDecimal(" "));
    }
}
