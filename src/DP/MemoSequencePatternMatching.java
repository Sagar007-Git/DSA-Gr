package DP;

public class MemoSequencePatternMatching {
    static Boolean[][] memo;

    public static void main(String[] args) {
        System.out.println(fun("AXXXXXXXXXXXXXXGHDGH","AXXy"));
    }
    static boolean fun(String a, String b){
        int m = a.length();
        int n = b.length();
        memo = new Boolean[m+1][n+1];
        return helper(a,b,m,n);
    }

    private static boolean helper(String a, String b, int m, int n){
        if(m==0) return true;
        if(n==0 || m<0 ) return false;
        if(memo[m][n]!=null) return memo[m][n];
        if(a.charAt(m-1)==b.charAt(n-1)) return memo[m][n]  = helper(a,b,m-1,n-1);
        return  memo[m][n]  = helper(a,b,m,n-1);

    }
}
