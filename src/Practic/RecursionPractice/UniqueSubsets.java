package Practic.RecursionPractice;

import java.util.ArrayList;
import java.util.List;

public class UniqueSubsets {
    public static void main(String[] args) {
        System.out.println(solve("aabbccc"));

    }



    static List<List<String>> solve(String str){

        return helper(str,new ArrayList<>(),"");
        }
        private static List<List<String>> helper(String str, List<List<String>> list, String op ){
                if(str.isEmpty() && !(list.contains(op))){
                    List<String> list1 = new ArrayList<>();
                    list1.add(op);
                    list.add(list1);
                    return list;
                }

                char ch= str.charAt(0);
                List<List<String>> op1 = helper(str.substring(1), list, op );
                List<List<String>> op2 = helper(str.substring(1), list, op+ch );
                return list;
        }
}
