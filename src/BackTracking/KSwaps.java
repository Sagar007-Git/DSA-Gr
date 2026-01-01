package BackTracking;

public class KSwaps {
    public static void main(String[] args) {
        System.out.println(fun("59789",5));
    }

    static String fun(String str, int k){
       String res = str;
        helper(str.toCharArray(),res,0,k);
        return res;
    }

    private static void helper(char[] arr,String res, int iterator, int k) {
        if(k==0 || iterator==arr.length-1){
            return ;
        }
        for (int i = iterator+1; i < arr.length; i++) {
            int maxDigit = max(arr, iterator);
            if(arr[i]-'0'==maxDigit){
                    swap(arr,iterator,i);
                    helper(arr, res,iterator+1, k-1);
                    String str = String.valueOf(arr);// Capture return value
                    if(str.compareTo(res)>0){
                        res = str;
                    }
                    swap(arr,iterator,i);

            }

        }
        helper(arr, res,iterator+1, k);
        return ;
    }

    private static void swap(char[] arr, int iterator, int i) {
        char temp = arr[i];
        arr[i] = arr[iterator];
        arr[iterator] = temp;
    }

    private static int max(char[] arr, int iterator) {
        int maxDigit = arr[iterator];
        for (int i = iterator; i < arr.length; i++) {
            if (arr[i]-'0'>maxDigit) maxDigit =arr[i]-'0';
        }
        return maxDigit;
    }
}

