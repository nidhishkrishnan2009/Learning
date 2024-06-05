package com.learning.interview;

import java.util.Arrays;
import java.util.Random;

public class ArrayShuffle {
    private static int[] shuffle(int[] arr,int n){
        Random random=new Random();
        int temp;
        for(int i=n-1;i>0;i--){
            int j= random.nextInt(i);
            temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{3,7,2,5,9,1};
        System.out.println("Before shuffling");
        System.out.println(Arrays.toString(arr));
        System.out.println("After shuffling");
        System.out.println(Arrays.toString(shuffle(arr,arr.length)));
    }
}
