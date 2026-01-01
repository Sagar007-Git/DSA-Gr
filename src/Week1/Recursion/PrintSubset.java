package Week1.Recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PrintSubset {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        HashSet<String> set = new HashSet<>();
        recursive(str,"", set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.print(s+" ");
        }
    }

    static void recursive(String ip, String op, HashSet<String> set){
        if(ip.length()==0) {
            set.add(op);
            return;
        }
        recursive(ip.substring(0,ip.length()-1),op, set);
        recursive(ip.substring(0,ip.length()-1),ip.charAt(ip.length()-1)+op, set);

    }

}
