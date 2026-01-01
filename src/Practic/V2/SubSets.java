package Practic.V2;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public static void main(String[] args) {
        System.out.println(fun("", "aab",new ArrayList<>()));

    }
    static List<List<String>> fun(String op, String str,List<List<String>> list ){
        if(str.isEmpty()){
            List<String> list1 = new ArrayList<>();
            list1.add(op);
            list.add(list1);
            return  list;
        }
        char ch = str.charAt(0);
        List<List<String>> withChar = fun(op+ch,str.substring(1),list);
        List<List<String>> withoutChar = fun(op, str.substring(1),list);
        return list;

    }

}
