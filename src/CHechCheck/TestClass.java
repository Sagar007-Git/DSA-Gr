package CHechCheck;

import java.io.*;
import java.util.*;

public class TestClass {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int n = Integer.parseInt(br.readLine().trim());
        String[] arr_a = br.readLine().split(" ");
        int[] a = new int[n];
        for (int i_a = 0; i_a < arr_a.length; i_a++) {
            a[i_a] = Integer.parseInt(arr_a[i_a]);
        }

        long out_ = solve(n, a);
        System.out.println(out_);

        wr.close();
        br.close();
    }

    static long solve(int N, int[] arr){

        if(N==1){
            return arr[0];
        }

        long sum = 0;
        Arrays.sort(arr);

        if(arr[0]<0 && arr[arr.length-1]>0){
            for(int i=0; i<N; i++){
                if(arr[i]<=0){
                    sum-=(arr[i]);
                } else {
                    sum+=arr[i];
                }
            }
            return sum;

        }else if(arr[0]<0 && arr[N-1]<0){
            sum=arr[N-1];
            for(int i=N-2; i>=0; i--){
                sum-=arr[i];
            }
            return sum;


        }else {
            sum=arr[0];
            if(arr[0]==arr[N-1]){
                return (long) arr[0] *(N-2);
            }
            for(int i=1; i<N; i++){
                if(sum==0 || i==1){
                    sum  = sum-arr[i];
                }
                else{
                    sum=arr[i]-sum;
                }
            }
            return sum;
        }


    }
}
