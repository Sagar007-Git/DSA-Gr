package A_PracticeLCS;


import java.util.Arrays;
import java.util.Map;

//Given two strings, find the number of times the second string occurs in the first string, whether continuous or discontinuous.
public class ABSubseqTimes {
    static int[][] memo;
    public static void main(String[] args) {
        System.out.println(fun("GeeksforGeeks","Gks"));
    }
    static int fun(String s1, String s2){
        int m = s1.length();
        int n = s2.length();
        memo = new int[m+1][n+1];
        for (int[] row : memo) Arrays.fill(row,-1);
        return helper(s1,s2,m,n);
    }

    private static int helper(String s1, String s2, int m, int n) {
        if(n==0) return 1;
        if(m==0) return 0;
        if(memo[m][n]!=-1) return memo[m][n];

        if(s1.charAt(m-1)==s2.charAt(n-1)){
            return memo[m][n] =helper(s1,s2,m-1,n) + helper(s1,s2,m-1,n-1);
        }
        return memo[m][n] = helper(s1,s2,m-1,n);
    }
}
