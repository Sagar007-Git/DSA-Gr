package Practic.V2;

public class SymbolGrammer {
    public static void main(String[] args) {
        System.out.println(fun(3, 3));
    }
    static int fun(int n, int k){
        if(n==0 || n==1){
            return 0;
        }
        int mid =(int) Math.pow(2,n-1)/2;
        if(k<=mid){
            return fun(n-1,k);
        } else{
            return 1-(fun(n-1,k-mid));
        }
    }
}
