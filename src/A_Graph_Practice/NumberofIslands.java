package A_Graph_Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberofIslands {

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
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!vis[i][j] && mat[i][j]==1) {
                    bfs(mat, vis, i, j, n, m);
                    count++;
                }
            }
        }
        System.out.println(count);


    }

    static void dfs(int[][] mat, boolean[][] vis, int row, int col, int n, int m){
        vis[row][col] = true;
        int[] x = {1,1,1,0,0,-1,-1,-1};
        int[] y = {-1,0,1,1,-1,1,0,-1};
        for (int i = 0; i < 8; i++) {
            int nrow = row+x[i];
            int ncol = col+y[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && mat[nrow][ncol]==1){
                dfs(mat, vis, nrow, ncol, n, m);
            }
        }

    }

    static void bfs(int[][] mat, boolean[][] vis, int k, int l, int n, int m) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(k, l));
        vis[k][l] = true;
        while (!q.isEmpty()) {
            int row = q.peek().row;
            int col = q.peek().col;
            q.poll();
            int[] x = {1, 1, 1, 0, 0, -1, -1, -1};
            int[] y = {-1, 0, 1, 1, -1, 1, 0, -1};
            for (int i = 0; i < 8; i++) {
                int nrow = row + x[i];
                int ncol = col + y[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && mat[nrow][ncol] == 1) {
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }

            }
        }
    }
}

/*
5 5
1 1 0 0 0
0 1 0 0 1
1 0 0 1 0
0 0 0 0 0
0 1 0 1 1
*/
