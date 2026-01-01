package Practic;

import java.util.ArrayList;
import java.util.Arrays;

public class SortingSequence {
    public static void main(String[] args) {
        System.out.println((sortSentence("is2 sentence4 This1 a3")));
    }
    static  String sortSentence(String s) {
        String[] string = s.split(" ");
        StringBuilder str = new StringBuilder();
        int index = 1;
        for (int i = 0; i < string.length; i++) {
            for (int j = i; j < string.length; j++) {
                int c = Character.getNumericValue(string[j].charAt(string[j].length()-1));
                if(index==c){
                    string[j] = string[j].substring(0,string[j].length()-1);
                        String temp = string[i];
                        string[i]=string[j];
                        string[j] = temp;
                        index++;
                        break;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < string.length; i++) {
            if(i==0){
                res.append(string[i]);
            } else res.append(" ").append(string[i]);
        }
        return res.toString();

    }
}
