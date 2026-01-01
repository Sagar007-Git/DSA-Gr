import java.util.Scanner;

public class Niana {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] arr = str.toLowerCase().toCharArray();
        System.out.println(fun(arr, arr.length));

    }

    static boolean fun(char[] arr, int n){
        int i=0;
        int j=n-1;
        while (i<j){
            if(arr[i]!=j) return false;
            i++;
            j--;
        }
        return true;
    }
}
