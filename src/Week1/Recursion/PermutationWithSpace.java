package Week1.Recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PermutationWithSpace {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        HashSet<String> set = new HashSet<>();
        recursive(str, "", 1, set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.print(s+" ");
        }
    }

    static void recursive(String ip, String op, int flag, HashSet<String> set){
        if(ip.length()==0){
            set.add(op);
            return;
        }
        if(flag==0) recursive(ip, op+"_",1,set);
        recursive(ip.substring(1), op+ip.charAt(0),0,set);
    }
}
