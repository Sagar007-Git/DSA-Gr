package Practic.RecursionPractice;

public class RemoveDuplicates {
    public static void main(String[] args) {
        String str = "aabbccddeeff";
        System.out.println("Original String: " + str);
        String result = removedup(str);
        System.out.println("String after removing duplicates: " + result);
    }

    static String removedup(String str){
        if(str.length()==0){
            return "";
        }
        char temp = str.charAt(str.length()-1);
        String val = removedup(str.substring(0,str.length()-1));
        return insert(val, temp);
    }

    private static String insert(String str,  char temp){
        if(str.length()==0 || str.charAt(str.length()-1)!=temp){
            return str+=temp;
        }
        return str;

    }
}
