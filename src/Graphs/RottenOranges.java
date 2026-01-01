package Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class RottenOranges {

    static class Pair{
        int row;
        int col;
        int tm;

        public Pair(int row, int col, int tm) {
            this.row = row;
            this.col = col;
            this.tm = tm;
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        int[][] vis = new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        int countFresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
                vis[i][j] = mat[i][j];
                if(mat[i][j]==2) {
                    q.add(new Pair(i,j,0));
                }
                if(mat[i][j]==1) countFresh++;
            }
        }

        int time  = 0;
        while (!q.isEmpty()){
            int row = q.peek().row;
            int col = q.peek().col;
            int tm = q.peek().tm;
            time = Math.max(time,tm);
            q.poll();
            for (int i = -1; i <=1; i++) {
                for (int j = -1; j <=1 ; j++) {
                    if(Math.abs(i)+Math.abs(j) !=1) continue;
                    int nrow  = row + i;
                    int ncol = col + j;

                    if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]!=2 && mat[nrow][ncol]==1){
                        countFresh--;
                        q.add(new Pair(nrow, ncol,tm+1));
                        vis[nrow][ncol] = 2;
                    }
                }
            }
        }

        for (int i = 0; i <n ; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(vis[i][j]+" ");
            }
            System.out.println();
        }

        if (countFresh!=0) {
            System.out.println(-1);
            return;
        }
        System.out.println(time);
        return;

    }

}
