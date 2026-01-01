package A_Graph_Practice;

import java.util.Scanner;

public class FloodFill {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int row = scan.nextInt();
        int col = scan.nextInt();
        int newClr = scan.nextInt();
        int[][] mat = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
            }
        }
        int clr = mat[row][col];
        System.out.println();
        dfs(mat, vis, newClr, clr, row, col, n, m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }


    }

    static void dfs(int[][] mat, boolean[][] vis, int newClr, int clr, int row, int col, int n, int m){
        vis[row][col] = true;
        mat[row][col] = newClr;
        int[] x = {1,1,1,0,0,-1,-1,-1};
        int[] y = {1,0,-1,1,-1,1,-1,0};
        for (int i = 0; i < 8; i++) {
            int nrow = row+x[i];
            int ncol = col+y[i];
            if(ncol>=0 && ncol<m && nrow>=0 && nrow<n && !vis[nrow][ncol] && mat[nrow][ncol]==clr){
//                mat[nrow][ncol] = newClr;
                dfs(mat, vis, newClr, clr, nrow, ncol, n, m);
            }
        }
    }
}
