    package DP;

    import java.util.Arrays;

    public class MemoLCSubString {
        static int[][][] memo;
        public static void main(String[] args) {
            System.out.println(fun("abcde","abfde"));
        }

        static int fun(String x, String y){
            memo = new int[x.length()+1][y.length()+1][Math.max(x.length(),y.length())];
            for(int[][] matrix : memo) {
                for (int[] row :matrix) Arrays.fill(row,-1);
            }
            return helper(x,y,x.length(),y.length(),0);
        }

        private static int helper(String x, String y, int m, int n, int maxLen) {
            if(m==0 || n ==0) return maxLen;
            if(memo[m][n][maxLen]!=-1) return memo[m][n][maxLen];
            if(x.charAt(m-1)==y.charAt(n-1)) return memo[m][n][maxLen] =helper(x,y,m-1,n-1,maxLen+1);
            return memo[m][n][maxLen] = Math.max(maxLen,Math.max(helper(x,y,m-1,n,0),helper(x,y ,m,n-1,0)));
        }
    }
