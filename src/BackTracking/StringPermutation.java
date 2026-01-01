package BackTracking;

import java.util.ArrayList;

public class StringPermutation {
    public static void main(String[] args) {
        System.out.println(fun("ABC"));
    }
    static ArrayList<String> fun(String str){
        ArrayList<String> list = new ArrayList<>();
        return helper(str.toCharArray(), 0,list);
    }

    private static ArrayList<String> helper(char[] str, int iterator, ArrayList<String> list) {
        if(iterator==str.length-1){
            list.add(new String(str));
            return list;
        }

        for (int i = iterator; i < str.length ; i++) {
            swap(str,i,iterator);
            helper(str,iterator+1,list);
            swap(str,i,iterator);
        }
        return list;
    }

    private static void swap(char[] arrChar, int i, int iterator) {
        char temp = arrChar[i];
        arrChar[i] = arrChar[iterator];
        arrChar[iterator] = temp;
    }
}
