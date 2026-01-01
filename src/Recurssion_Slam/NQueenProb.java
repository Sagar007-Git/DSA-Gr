package Recurssion_Slam;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class NQueenProb {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] mat = new int[n][n];
        System.out.println(fun(0,n,mat,new ArrayList<>(), new ArrayList<>()));
    }

    static ArrayList<ArrayList<Integer>> fun(int row, int n, int[][] mat, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> list) {
        if (row == n) {
            if (temp.size() == n) {
                list.add(new ArrayList<>(temp));
            }
            return list;
        }
        for (int i = 0; i < n; i++) {
            if(temp.contains(i)) continue;
            if(row==0){
                temp.add(i);
                mat[row][i] = 1;
                fun(row+1, n, mat, temp, list);
                temp.removeLast();
                mat[row][i] = 0;
            } else if (i==0) {
                if(mat[row-1][i+1]!=0) continue;
                temp.add(i);
                mat[row][i] = 1;
                fun(row+1, n, mat, temp, list);
                temp.removeLast();
                mat[row][i] = 0;
            } else if (i==n-1) {
                if(mat[row-1][i-1]!=0) continue;
                temp.add(i);
                mat[row][i] = 1;
                fun(row+1, n, mat, temp, list);
                temp.removeLast();
                mat[row][i] = 0;
            }else{
                if(mat[row-1][i-1]!=0 || mat[row-1][i+1]!=0) continue;
                temp.add(i);
                mat[row][i] = 1;
                fun(row+1, n, mat, temp, list);
                temp.removeLast();
                mat[row][i] = 0;
            }
        }
        return list;
     }
    }

