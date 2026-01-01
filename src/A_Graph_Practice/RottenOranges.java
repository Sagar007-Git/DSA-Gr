package A_Graph_Practice;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {
    static int count =0;
    static class Pair{
        int row;
        int col;
        int t;
        public Pair(int row, int col, int t) {
            this.row = row;
            this.col = col;
            this.t = t;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> queue  = new LinkedList<>();
        int toBeRotten = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
                if(mat[i][j]==2) queue.add(new Pair(i,j,0));
                if(mat[i][j]==1) toBeRotten++;
            }
        }
        int res = bfs(mat, vis, n, m, queue);
        System.out.println(count==toBeRotten ? res : -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        };
    }
    private static int bfs(int[][] mat, boolean[][] vis, int n, int m, Queue<Pair> queue) {
        int maxTime = 0;
        while (!queue.isEmpty()){
            int row = queue.peek().row;
            int col = queue.peek().col;
            int t = queue.poll().t;
            if(maxTime<t) maxTime=t;
            vis[row][col] = true;
            int x[] = {1, 0, 0, -1};
            int y[] = {0, -1, 1, 0};
            for (int i = 0; i < 4; i++) {
                int nrow = row+x[i];
                int ncol = col+y[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && !vis[nrow][ncol] && mat[nrow][ncol]==1){
                    vis[nrow][ncol] = true;
                    mat[nrow][ncol]=2;
                    count++;
                    queue.add(new Pair(nrow, ncol,t+1));
                }
            }
        }
        return maxTime;
    }
}
