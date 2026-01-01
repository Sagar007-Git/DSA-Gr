package BackTracking;

import java.util.ArrayList;

public class MazeHadRat {
    public static void main(String[] args) {
        int[][] maze = {
                {1, 0, 0, 0},
                {1, 1, 0, 1},
                {1, 1, 1, 0},
                {0, 1, 1, 1}
        };

        fun(maze);
    }
    static void fun(int[][] arr){
        ArrayList<String> list = new ArrayList<>();
        helper(arr,0,0,"",list,arr.length);
        System.out.println(list);
    }

    private static void helper(int[][] arr, int r, int c, String str, ArrayList<String> list,int n) {
        if(r==n-1 && c==n-1){
            list.add(str);
            return;
        }

        arr[r][c]=0;
            if(c!=n-1 && arr[r][c+1]==1){
               ;
                helper(arr,r,c+1, str+"R",list,n);
            }
            if(r!=n-1 && arr[r+1][c]==1){
                ;
                helper(arr,r+1,c,str+"D",list,n);
            }
            if(c!=0 && arr[r][c-1]==1){
                ;
                helper(arr,r,c-1,str+"L",list,n);
            }
            if(r!=0 && arr[r-1][c]==1){
                ;
                helper(arr,r-1,c,str+"U",list,n);
            }

        arr[r][c]=1;

    }

}
