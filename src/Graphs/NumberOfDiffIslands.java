package Graphs;

import java.util.Scanner;

public class NumberOfDiffIslands {
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
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dfs(mat,vis, i,j,n,m,mat[i][j]);
                count++;
            }
        }
        System.out.println(count);

    }

    private static void dfs(int[][] mat, boolean[][] vis, int row, int col, int n, int m, int land) {
        vis[row][col] = true;
        int[] x = {-1, 0, 0, 1};
        int[] y = {0, 1, -1, 0};
        for (int i = 0; i < 4; i++) {
            int nrow = row+x[i];
            int ncol = col+y[i];

            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && mat[nrow][ncol]==land){
                dfs(mat,vis, nrow, ncol, n, m, land);
            }
        }
    }


}
