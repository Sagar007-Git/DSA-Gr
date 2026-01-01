package A_Practice_String;

import java.util.HashSet;

public class PanagramChecking {
    public static void main(String[] args) {
        System.out.println(fun("The quick brown fox jumps over the dog"));
    }
    static boolean fun(String s){
        HashSet<Character> set = new HashSet<>();
        for(char c : s.toCharArray()){
            if(c!=' ') set.add(Character.toLowerCase(c));
        }
        System.out.println(set.size());
        return set.size()==26;
    }
}
