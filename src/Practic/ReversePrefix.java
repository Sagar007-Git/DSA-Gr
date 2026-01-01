package Practic;

import java.util.Arrays;

public class ReversePrefix {
    public static void main(String[] args) {
        System.out.println(reversePrefix("abcdefd",'d'));
    }
    static String reversePrefix(String word, char ch) {
        char[] str = word.toCharArray();
        int index = word.indexOf(ch);
        int i=0;
        while(i<index){
            char temp = str[i];
            str[i] = str[index];
            str[index] = temp;
            i++;
            index--;
        }
        return String.valueOf(str);
    }
}
