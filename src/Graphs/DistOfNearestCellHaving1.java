package Graphs;

import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class DistOfNearestCellHaving1 {

    static class Pair{
        int row;
        int col;
        int step;

        public Pair(int row, int col, int step) {
            this.row = row;
            this.col = col;
            this.step = step;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int[] arr : vis) Arrays.fill(arr, -1);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
                if(mat[i][j]==1){
                    vis[i][j] = 0;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        while (!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int step = q.peek().step;
            q.poll();
            for (int i = -1; i <=1 ; i++) {
                for (int j = -1; j <=1 ; j++) {
                    if(Math.abs(i)+Math.abs(j)!=1) continue;
                    int nrow = row+i;
                    int ncol = col+j;
                    int nstep = step+1;
                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==-1  ){
                        vis[nrow][ncol] = nstep;
                        q.add(new Pair(nrow, ncol,nstep));
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }

    }

}
