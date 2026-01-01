package Graphs;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int m = scan.nextInt();
        int n = scan.nextInt();
        int row = scan.nextInt();
        int col = scan.nextInt();
        int changeTo = scan.nextInt();
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }
        boolean[][] arr = new boolean[n][n];
        int colCheck = matrix[row][col];
        fun(matrix, colCheck,changeTo,row,col,m,n,arr);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }

    }
    static void fun(int[][] mat, int colCheck, int changeTo, int row, int col, int m, int n, boolean[][] arr){
        arr[row][col] = true;
        mat[row][col] = changeTo;
        for (int i = -1; i <=1 ; i++) {
            for (int j = -1; j <=1 ; j++) {
                if(Math.abs(i) + Math.abs(j) !=1) continue;
                int nrow = row+i;
                int ncol  = col+j;

                if (nrow>=0 && nrow<m && ncol>=0 && ncol<n && !arr[nrow][ncol] && mat[nrow][ncol]==colCheck){
                    fun(mat,colCheck,changeTo, nrow, ncol,m,n,arr);
                }
            }
        }
    }
}
