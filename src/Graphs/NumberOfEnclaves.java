package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberOfEnclaves {

    static class Pair{
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

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
            if (mat[0][j] == 1 && !vis[0][j]) {
                fun(mat, vis, 0, j, n, m);
            }
            if (mat[n - 1][j] == 1 && !vis[n - 1][j]) {
                fun(mat, vis, n - 1, j, n, m);
            }
        }

        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 1 && !vis[i][0]) {
                fun(mat, vis, i, 0, n, m);
            }
            if (mat[i][m - 1] == 1 && !vis[i][m - 1]) {
                fun(mat, vis, i, m - 1, n, m);
            }
        }

        System.out.println();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(mat[i][j]==1 && !vis[i][j]) count++;
            }
        }
        System.out.println(count);



    }

    static void fun(int[][] mat, boolean[][] vis, int i, int j, int n, int m){
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        while (q.isEmpty()){
            int row = q.peek().row;
            int col = q.poll().col;

            int[] x = {-1, 0, 0, 1};
            int[] y = {0, -1, 1, 0};
            for (int k = 0; k < 4; k++) {
                int nrow = row+x[k];
                int ncol = col+y[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && mat[nrow][ncol]==1){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
}
