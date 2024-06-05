package com.learning.interview;

import java.util.Arrays;

public class SecondMinNoInArray {

    public SecondMinNoInArray(){

    }
    private static int findSecondMax(int arr[]){
        int min=Integer.MAX_VALUE,secondMin=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<min){
                secondMin=min;
                min=arr[i];
            }
            else if(arr[i]>min && arr[i]<secondMin && secondMin!=min){
                secondMin=arr[i];
            }
        }
        return secondMin;
    }

    public static void main(String[] args) {
        System.out.println(findSecondMax(new int[]{6,7,20,5,4,4}));
    }
}
