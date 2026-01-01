package A_Random;

public class MinimumSwap {
    static int swap;
    static int minVal;
    static int num1;
    static int num2;
    public static void main(String[] args) {
        fun(3527,2715);
    }
    static void fun(int a ,int b){
        num1 = a;
        num2 = b;
        int size=0;
        int temp = a;
        while(temp>0){
            temp/=10;
            size++;
        }
        System.out.println(size);
        if(a-b==0) return ;
        swap=0;
        minVal=Math.abs(a-b);
        System.out.println(minVal);
        helper(a,b,0,0,size);
        System.out.println(minVal);
        System.out.println(swap);

    }

    private static int helper(int a, int b, int index, int tempSwap,int size) {
        if(index==size) return swap;
        int temper = 1;
        for (int i = index; i <size ; i++) {
            if(temper>size-2 || index==size) break;
            String s1 = Integer.toString(a);
            String s2 = Integer.toString(b);

            // Swap digits at position 2 (0-based index)
            int swapPos = i;
            char[] arr1 = s1.toCharArray();
            char[] arr2 = s2.toCharArray();

            // Perform the swap
            char temp = arr1[swapPos];
            arr1[swapPos] = arr2[swapPos];
            arr2[swapPos] = temp;

            // Convert back to integers
            a = Integer.parseInt(new String(arr1));
            b = Integer.parseInt(new String(arr2));
            System.out.println(a+","+b);
            System.out.println(a-b);// 456 →
            if(minVal>=Math.abs(a-b)) {
                minVal = Math.abs(a - b);
                swap = temper;
                if(minVal == Math.abs(a-b) && swap>temp) swap = temper;
            }
            System.out.println("temp - "+temper);
            temper++;

        }
        System.out.println("---------------------");
        helper(num1, num2,index+1,0,size);
        return swap;
    }

}
