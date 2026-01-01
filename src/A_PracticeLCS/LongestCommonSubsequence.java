package A_PracticeLCS;

import java.lang.reflect.Array;
import java.util.Arrays;

public class LongestCommonSubsequence {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun("AXRCF","GXAGXJHRLKOCF"));
    }
    static int fun(String s1,String s2){
        int m = s1.length();
        int n = s2.length();
        memo = new int[m][n];
        for(int[] row :memo) Arrays.fill(row,-1);
        int res = helper(s1,s2,m-1,n-1);;
        printMatrix(s1,s2);
        return res;
    }

    static int helper(String s1, String s2, int m, int n) {
        if(m==0 || n==0) {
            return 0;
        };
        if(memo[m][n]!=-1) return memo[m][n];
        if(s1.charAt(m)==s2.charAt(n)){
            memo[m][n] = 1+helper(s1,s2,m-1,n-1);
        }else {
            int left = helper(s1, s2, m-1, n);   // Explore left
            int top = helper(s1, s2, m, n-1);    // Explore top
            memo[m][n] = Math.max(left, top);
        }
        return memo[m][n];

    }

    private static void printMatrix(String s1, String s2) {
        System.out.println("\nMemoization Matrix:");
        System.out.print("     ");
        // Print header (s2 characters)
        for (int j = 0; j < s2.length(); j++) {
            System.out.print(s2.charAt(j) + " ");
        }
        System.out.println();

        // Print matrix rows
        for (int i = 0; i <= s1.length(); i++) {
            // Print row header (s1 characters)
            if (i > 0) {
                System.out.print(s1.charAt(i - 1) + " ");
            } else {
                System.out.print("  ");
            }

            // Print matrix values
            for (int j = 0; j <= s2.length(); j++) {
                System.out.print(memo[i][j] + " ");
            }
            System.out.println();
        }
    }

}
