package A_PracticeLCS;

import java.util.Arrays;

public class LongestCommonSubString {
    static int[][] memo;
    static int memoLen;

    public static void main(String[] args) {
        System.out.println(fun("ABMNCDC","ABrdMNCDCC"));
    }

    static int fun(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        memo = new int[m+1][n+1];
        for(int[] arr : memo) Arrays.fill(arr,-1);
        helper(s1,s2,m,n);
        printMatrix(s1, s2); // Print the matrix after computation
        return memoLen;
    }

    private static int helper(String s1, String s2, int m, int n) {
        if(m==0 || n==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];
        int countLen = 0;
        if(s1.charAt(m-1)==s2.charAt(n-1)){
            countLen = 1+helper(s1,s2,m-1,n-1);
            memoLen = Math.max(memoLen,countLen);
        }
        helper(s1,s2,m-1,n);
        helper(s1,s2,m,n-1);
         memo[m][n] = countLen;
         return countLen;
    }

    private static void printMatrix(String s1, String s2) {
        System.out.println("\nMemoization Matrix:");
        System.out.print("    ");
        // Print header (s2 characters)
        for (int j = 0; j < s2.length(); j++) {
            System.out.print(s2.charAt(j) + " ");
        }
        System.out.println();

        // Print matrix rows
        for (int i = 0; i <= s1.length(); i++) {
            // Print row header (s1 characters)
            if (i > 0) {
                System.out.print(s1.charAt(i-1) + " ");
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