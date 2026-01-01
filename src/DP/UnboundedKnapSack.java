package DP;

public class UnboundedKnapSack {
    public static void main(String[] args) {
        int[] wt = {1, 3, 4, 5};
        int[] val = {10, 40, 50, 70};
        int W = 8;
        System.out.println(fun(wt,val,W));
    }
    static int fun(int[] wt, int[] val, int W){
        return helper(wt,val,W,0,0);
    }

    private static int helper(int[] wt, int[] val, int w, int iterator,int prf) {
        if(w==0 || iterator==wt.length) return prf;
        if(wt[iterator]<=w){
            return Math.max(helper(wt,val,w-wt[iterator],iterator+1,prf+val[iterator]), helper(wt,val,w-wt[iterator],iterator,prf+val[iterator]));
        }
       return helper(wt,val,w,iterator+1,prf);

    }
}
