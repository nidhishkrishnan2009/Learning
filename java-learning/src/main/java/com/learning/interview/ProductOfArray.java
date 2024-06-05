package com.learning.interview;

import java.util.Arrays;

// Using prefix - suffix multiplication.
public class ProductOfArray {

    public static void main(String[] args) {
        productOfArray(new int[]{10, 3, 5, 6, 2});
    }
    private static void productOfArray(int[] arr){
        int len=arr.length;
        if(len==1){
            return;
        }
        int[] prefix=new int[len];
        int[] suffix=new int[len];
        prefix[0]=1;
        suffix[len-1]=1;

        //construct prefix array
        for(int i=1;i<len;i++){
            prefix[i]=arr[i-1]*prefix[i-1];
        }
        //Construct suffix array
        for(int i=len-2;i>=0;i--){
            suffix[i]=arr[i+1]*suffix[i+1];
        }
        for(int i=0;i<len;i++){
            arr[i]=prefix[i]*suffix[i];
        }

        System.out.println(Arrays.toString(arr));
    }
}
