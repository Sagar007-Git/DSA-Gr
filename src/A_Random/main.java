package A_Random;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class main {
    static int maxHeight;
    static int[][][]  memo;
    public static void main(String[] args) {
        int[] rods = {1,2,3,6,6,6};
                maxHeight =0;
                int sum = Arrays.stream(rods).sum();
                int n = rods.length;
                memo = new int[n+1][sum+1][sum+1];
                for(int[][] mat : memo){
                    for(int[] row : mat) Arrays.fill(row, -1);
                }
                int max = helper(rods,n,0,0,sum);
                System.out.println(max);
            }
            public static int helper(int[] arr, int n, int left, int right, int sum){
                if(left==right && left>maxHeight) maxHeight=left;
                if(n==0) return maxHeight;
                if(memo[n][left][right]!=-1) return memo[n][left][right];
                if(left+arr[n-1]<=(sum/2)+1)  return memo[n][left][right] = helper(arr, n-1, left+arr[n-1], right, sum);
                if(right+arr[n-1]<=(sum/2)+1) return memo[n][left][right] = helper(arr, n-1, left, right+arr[n-1], sum);
                return memo[n][left][right] = helper(arr, n-1, left, right, sum);

        }
    }

