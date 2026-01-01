package Week1.Recursion;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class PermutationCaseChange {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String str = scan.nextLine();
        HashSet<String> set = new HashSet<>();
        permutation(str,"",set);
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String s = iterator.next();
            System.out.print(s+" ");
        }

    }
    static void permutation(String ip, String op, HashSet<String> set){
        if(ip.length()==0){
            set.add(op);
            return;
        }
        permutation(ip.substring(1),op+ip.toLowerCase().charAt(0),set);
        permutation(ip.substring(1),op+ip.toUpperCase().charAt(0),set);
    }
}
