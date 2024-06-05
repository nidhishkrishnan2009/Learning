package com.learning.interview;

import lombok.AllArgsConstructor;

import java.util.Arrays;

public class FractionalKnapSackProblem {

    public static void main(String[] args) {
        System.out.println(knapSackSolution(new Item[]{new Item(100, 20), new Item(60, 10), new Item(120, 30)}, 50));
    }

    private static int knapSackSolution(Item[] arr,int capacity){
        Arrays.sort(arr, (item1,item2)->{
            Double item1Fraction=Double.valueOf((double)item1.profit/(double)item1.weight);
            Double item2Fraction=Double.valueOf((double)item2.profit/(double)item2.weight);
            return item1Fraction<item2Fraction?1:-1;
        });
        int result=0;
        for(Item item:arr){
            int profit=item.profit;
            int weight= item.weight;
            if(capacity-weight>=0){
                result+=profit;
                capacity-=weight;
            }
            else{
                double fractionalResult=profit*((double)capacity/(double)weight);
                result+=fractionalResult;
                capacity-=weight*((double)capacity/(double)weight);
                break;
            }


        }
        return result;
    }
    @AllArgsConstructor
    static class Item{
        private int profit;
        private int weight;
    }
}
