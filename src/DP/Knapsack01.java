package DP;

public class Knapsack01 {
        static int[][] arr;
    public static void main(String[] args) {
        int[] val = {40, 50, 100};
        int[] wt = {3, 2, 5};
        int W = 6;
        int row = W;
        int col = val.length;
        arr = new int[row][col];
//        static int[][] arr = new int[val.length+1][W+1]// Knapsack capacity
        System.out.println(pract(wt,val,W));;
    }
    static int pract(int[] wt, int[] val, int maxWt ){
        return phelper(wt,val,0,maxWt,0);
    
    }

    private static int phelper(int[] wt, int[] val, int iterator, int maxWt, int profit) {
        if(maxWt<=0 || iterator == val.length){
            if(maxWt<0 && iterator!=0){
                return profit-val[iterator-1];
            }
            return profit;
        }

        int left = phelper(wt,val,iterator+1,maxWt-wt[iterator],profit+val[iterator]);
        int right = phelper(wt,val,iterator+1,maxWt,profit);
        return Math.max(left,right);

    }


    static int fun(int[] wt, int[] val, int maxWt){
        return helper(wt,val,maxWt,0,0,0);
    }












    private static int helper(int[] wt, int[] val, int maxWt, int curWt, int curPrft,int iterator ) {
        if(iterator==wt.length || curWt>=maxWt){
            if(curWt==maxWt){
                return curPrft;
            }
            if(iterator!=0 && curWt>maxWt){

                return curPrft-val[iterator-1];
            }
            if(iterator==0 && curWt>maxWt){
                return 0;
            }
            return curPrft;
        }
        int left = helper(wt,val,maxWt,curWt+wt[iterator],curPrft+val[iterator],iterator+1);
        int right = helper(wt,val,maxWt,curWt,curPrft,iterator+1);
        return Math.max(left,right);
    }
}
