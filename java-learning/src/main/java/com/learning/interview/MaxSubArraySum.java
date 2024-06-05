package com.learning.interview;

/**
 * Solution implemented using Kedan's Algorithm
 */
public class MaxSubArraySum {

    public static void main(String[] args) {
        System.out.println(maxSumSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }

    private static int maxSumSubArray(int arr[]){
        int maxSumSofar=Integer.MIN_VALUE, maxSumEndingHere=0;
        for(int i=0;i<arr.length;i++){
            maxSumEndingHere+=arr[i];
            if(maxSumSofar<maxSumEndingHere){
                maxSumSofar=maxSumEndingHere;
            }
            if(maxSumEndingHere<0){
                maxSumEndingHere=0;
            }
        }
        return maxSumSofar;
    }
}
