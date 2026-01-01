package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RatInMaze {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                mat[i][j] = scan.nextInt();
            }
        }
        ArrayList<String> list = new ArrayList<>();
        fun(new StringBuilder(), list, 0, 0, n, m, mat);
        System.out.println(list);
    }
    static ArrayList<String> fun(StringBuilder string,  ArrayList<String> list,  int row, int col, int n, int m, int[][] mat){
        if(row==3 && col==3){
            list.add(new String(string));
            return list;
        }
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};
        for (int i = 0; i < 4; i++) {
            int nrow = row+x[i];
            int ncol = col+y[i];
            string.append((i==0)?'R':(i==1)?'D':(i==2)?'L':'U');
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1){
                mat[row][col] = 0;
                fun(string, list, nrow, ncol, n, m, mat);
                mat[row][col] = 1;
            }
            string.deleteCharAt(string.length()-1);
        }
        return list;
    }
}
