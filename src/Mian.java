import java.util.Scanner;

public class Mian {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        char[] arr = str.toCharArray();
        int n = arr.length;
        int i=0;
        int j=n-1;
        while (i<=j){
            if(arr[i]!=arr[j]){
                System.out.println("Given string is not a palindrome");
                return;
            }
            i++;
            j--;
        }
        System.out.println("Given string is a Palindrome");




    }
}
