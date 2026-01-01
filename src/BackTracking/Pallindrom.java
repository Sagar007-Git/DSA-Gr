package BackTracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Pallindrom {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        List<List<String>> res = new ArrayList<>();
        backTrack(str,0,res,new ArrayList<>());
        System.out.println(res);

    }

    static List<List<String>> backTrack(String string,  int index, List<List<String>> res, List<String> list){
        if(index==string.length()){
            res.add(new ArrayList<>(list));
            return res;
        }
        for (int i = index; i < string.length(); i++) {
            if(isPalindrome(index,i,string)){
                list.add(string.substring(index,i+1));
                backTrack(string, i+1, res, list);
                list.removeLast();
            }
        }
        return res;
    }

    private static boolean isPalindrome(int index, int i, String string) {
        while (index<=i){
            if(string.charAt(index)!=string.charAt(i)) return false;
            index++;
            i--;
        }
        return true;
    }
}
