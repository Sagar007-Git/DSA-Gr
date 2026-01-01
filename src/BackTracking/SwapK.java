package BackTracking;

public class SwapK {
    static String res;
    public static void main(String[] args) {
        fun("92889799",1);
    }
    static void fun(String str, int k){
         res = str;
        helper(str.toCharArray(),k,0);
        System.out.println(res);
    }

    private static void helper(char[] arr, int k, int iterator) {
        if(k==0 || iterator== arr.length-1){
            return;
        }

        char maxDigit = arr[iterator];
        for (int i = iterator; i < arr.length; i++) {
            if (maxDigit<arr[i]){
                maxDigit=arr[i];
            }
        }

        for (int i = iterator+1; i < arr.length; i++) {
                if (arr[i]>arr[iterator] && arr[i]==maxDigit){
                    swap(arr,i,iterator);
                    String current = new String(arr);
                    if(current.compareTo(res)>0){
                        res=current;
                    }
                    helper(arr,k-1,iterator+1);
                    swap(arr,i,iterator);
                }
        }
        helper(arr,k,iterator+1);
    }

    private static void swap(char[] arr, int i, int iterator) {
        char temp = arr[i];
        arr[i] = arr[iterator];
        arr[iterator] = temp;
    }


}
