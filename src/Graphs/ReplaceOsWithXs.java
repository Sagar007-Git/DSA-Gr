package Graphs;

import java.util.Scanner;

public class ReplaceOsWithXs {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0 && !vis[0][j]) {
                fun(mat, vis, 0, j, n, m);
            }
            if (mat[n - 1][j] == 0 && !vis[n - 1][j]) {
                fun(mat, vis, n - 1, j, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0 && !vis[i][0]) {
                fun(mat, vis, i, 0, n, m);
            }
            if (mat[i][m - 1] == 0 && !vis[i][m - 1]) {
                fun(mat, vis, i, m - 1, n, m);
            }
        }

        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j]==0 && !vis[i][j]) mat[i][j] = 1;
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }


    }

    static void fun(int[][] vis, boolean[][] mat, int row, int col, int n, int m){
        mat[row][col] = true;
        for (int i = -1; i <=1; i++) {
            for (int j = -1; j <=1 ; j++) {
                if(Math.abs(i)+Math.abs(j) !=1) continue;
                int nrow = row+i;
                int ncol = col+j;

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !mat[nrow][ncol] && vis[nrow][ncol]==0){
                    fun(vis,mat,nrow,ncol,n,m);
                }
            }
        }
    }
}
