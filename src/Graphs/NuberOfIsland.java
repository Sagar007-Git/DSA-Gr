package Graphs;

import java.util.Scanner;

public class NuberOfIsland {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        boolean[][] arr = new boolean[n][n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(!arr[i][j] && matrix[i][j]==1){
                    fun(matrix,i,j,arr,n);
                    count++;
                }
            }
        }
        System.out.println(count);
        
    }

    static void fun(int[][] mat, int row, int col, boolean[][] arr, int n){
        arr[row][col] = true;
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <=1; j++) {
                if(i==0 && j==0) continue;
                int nrow = row+i;
                int ncol = col+j;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<n && mat[nrow][ncol]==1 && !arr[nrow][ncol] ){
                    fun(mat,nrow, ncol,arr,n);
                }
            }
        }
    }
}
