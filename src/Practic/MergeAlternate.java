package Practic;

public class MergeAlternate {
    public static void main(String[] args) {
        String s ="abcab";
        String target = "ab";
//        int StrLength = s.length();
//        String s1 = s.replace("ab","");
//        int replacedLen = s1.length();
//        System.out.println(replacedLen);
        int count=0;
        StringBuilder st = new StringBuilder();

        st.append(target);
        while(s.contains(st)){
            count++;
            st.append(target);
        }
        System.out.println(count);

    }
//    static String mergeAlternately(String word1, String word2) {
//        int i=0, j=0;
//        StringBuilder str = new StringBuilder();
//        while(i<word1.length() && j<word2.length()){
//            str.append(word1.charAt(i++));
//            str.append(word2.charAt(j++));
//        }
//
//        while (i<word1.length() ){
//            str.append(word1.charAt(i++));
//        }
//        while (j<word2.length()) {
//            str.append(word2.charAt(j++));
//        }
//        return String.valueOf(str);
//    }
//    public void  checkOnesSegment(String s) {
//
//}
}
