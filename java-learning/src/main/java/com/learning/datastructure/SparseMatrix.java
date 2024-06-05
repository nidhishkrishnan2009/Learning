package com.learning.datastructure;

public class SparseMatrix {
    public static void main(String[] args) {
        int[][] matrix= {
                {0 , 0 , 3 , 0 , 4 },
                {0 , 0 , 5 , 7 , 0 },
                {0 , 0 , 0 , 0 , 0 },
                {0 , 2 , 6 , 0 , 0 }
        };

        int size=0;
        for (int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                int data=matrix[i][j];
                if(data!=0){
                    size++;
                }

            }
        }

        int[][] sparseMatrix=new int[3][size];
        int k=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<5;j++){
                int data=matrix[i][j];
                if(data!=0){
                    sparseMatrix[0][k]=i;
                    sparseMatrix[1][k]=j;
                    sparseMatrix[2][k]=data;
                    k++;
                }
            }

        }

        for(int i=0;i<3;i++){
            for(int j=0;j<size;j++){
                System.out.println(sparseMatrix[i][j]);
            }
            System.out.println("\n");
        }
    }
}
