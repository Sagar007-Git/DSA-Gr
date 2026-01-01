package A_PracticeLCS;

public class PalindromeSubstringsCount {
    static int count;
    public static void main(String[] args) {
        fun("abbaeae");
    }
    static void fun(String s){
        int m = s.length();
        helper(s,0,m);
        System.out.println(count);
    }
    private static int helper(String s,  int iterator, int m){
        if (iterator==m) return 0;
        for (int i = iterator+1; i < m ; i++) {
            isPalindrome(s,iterator,i);
        }
        return helper(s,iterator+1,m);
    }

    private static void isPalindrome(String s, int iterator, int i) {
        while (iterator<i){
            if (s.charAt(iterator)!=s.charAt(i)) return ;
            iterator++;
            i--;
        }
        count++;
        return;
    }
}
