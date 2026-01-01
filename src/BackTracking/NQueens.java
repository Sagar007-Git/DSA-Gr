package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;

public class NQueens {
    public static void main(String[] args) {
        fun(4);
    }
    static void fun(int n){
        int[] arr = new int[n];
        int[][] matrix = new int[n][n];
        helper(arr,matrix,0,n);
        System.out.println(Arrays.toString(arr));
    }

    private static void helper(int[] arr, int[][] matrix, int col, int n) {
        if(col==n){
            return;
        }
        for (int i = 0; i < n; i++) {

            matrix[i][col]=1;
            if(!isBeside(i,col,matrix,n) && !isPresent(arr,i+1)){
                arr[col] = i+1;
                helper(arr,matrix, col+1,n);
            }
            matrix[i][col]=0;
        }
    }

    private static boolean isPresent(int[] arr, int i) {
        for (int j = 0; j < arr.length; j++) {
            if(arr[j]==i){
                return true;
            }
        }
        return false;
    }

    private static boolean isBeside(int row, int col, int[][] matrix, int n) {
        if(col==0){
            return false;
        }
        if(row!=0 && row!=n-1 && matrix[row+1][col-1]!=1 && matrix[row-1][col-1]!=1){
            return false;
        }
        if(row==0 && matrix[row+1][col-1]!=1){
            return  false;
        }
        if (row==n-1 && matrix[row-1][col-1]!=1){
            return false;
        }
        return true;
    }
}
