package Practic;

import java.util.ArrayList;
import java.util.Objects;

public class StringEqu {
    public static void main(String[] args) {
        System.out.println(arrayStringsAreEqual(new String[]{"ab", "c"},new String[]{"a", "bc"}));;
    }
    static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder str1 = new StringBuilder();
        StringBuilder str2 = new StringBuilder();
        for (int i = 0; i < word1.length; i++) {
            str1.append(word1[i]);
        }
        for (int i = 0; i < word2.length; i++) {
            str2.append(word2[i]);
        }
        return str1.toString().equals(str2.toString());
    }
}
