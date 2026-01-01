package HashMap;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

public class FreqOfChara {
    public static void main(String[] args) {
        fun("geeksforgeeks" );
    }
    static void fun(String str){
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
        }
        map.forEach((key,value)->{
            System.out.println(key +" : "+ value);
        });
    }
}
