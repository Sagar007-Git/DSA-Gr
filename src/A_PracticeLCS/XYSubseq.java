package A_PracticeLCS;

import java.util.Arrays;
//Find length of longest subsequence of one string which is substring of another string

public class XYSubseq {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun("ABCD","BACDBDCD"));
    }
    static int fun(String x, String y){
        int m = x.length();
        int n = y.length();
        memo = new int[m+1][n+1];
        for(int[] row : memo) Arrays.fill(row,-1);
        return helper(x,y,m,n);
    }

    private static int helper(String x, String y, int m, int n){
        if(m==0 || n==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        if(x.charAt(m-1)==y.charAt(n-1)){
            return memo[m][n] = 1+helper(x,y,m-1,n-1);
        }
        return memo[m][n]= helper(x,y,m,n-1);
    }
}
