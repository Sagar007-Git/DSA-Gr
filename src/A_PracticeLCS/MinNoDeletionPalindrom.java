package A_PracticeLCS;

import java.util.Arrays;

public class MinNoDeletionPalindrom {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun("aba"));
    }
    static int fun(String s){
        int m = s.length();
        memo = new int[m+1][m+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        int lpc = helper(s,0,m);
        return m-lpc;
    }

    private static int helper(String s, int m,int n) {
        if(m>n) return 0;
        if(memo[m][n]!=-1) return memo[m][n];
        int count = 2;
        if(s.charAt(m)==s.charAt(n-1)){
            if(m==n-1) count =1;
            return memo[m][n] = count + helper(s,m+1,n-1);
        }
        return memo[m][n] = Math.max(helper(s,m,n-1),helper(s,m+1,n));
    }

}
