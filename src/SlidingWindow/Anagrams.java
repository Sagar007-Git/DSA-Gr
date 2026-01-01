package SlidingWindow;

import java.util.Arrays;

public class Anagrams {
    public static void main(String[] args) {
        System.out.println(fun("abacbabc","xyt"));
    }
    static int fun(String text, String pattern){
        int[] counts = new int[26];
        for (int i = 0; i <pattern.length() ; i++) {
            counts[pattern.charAt(i)-'a']++;
        }
        int i=pattern.length()-1;
        StringBuilder str = new StringBuilder();
        for (int j = 0; j < pattern.length()-1; j++) {
            str.append(text.charAt(j));
        }
        int count = 0;
        while (text.length()>i){
            str.append(text.charAt(i));
            int[] check = Arrays.copyOf(counts,counts.length);
            for (int j = 0; j < str.length(); j++) {
                check[str.charAt(j)-'a']--;
            }
            int flag = 0;
            for (int j = 0; j < check.length; j++) {
                if(check[j]!=0){
                    flag=1;
                    break;
                }
            }
            if (flag==0){
                count++;
            }
            str.deleteCharAt(0);
            i++;

        }
        return count;

    }
}
