package BackTracking;

public class WordBreak {
    public static void main(String[] args) {
        String s = "ilikoe";
        String[] dictionary = { "i", "like", "gfg" };
        fun(s,dictionary,"");
        for (int i = 0; i < dictionary.length; i++) {
            if (!dictionary[i].equals("")){
                System.out.println(true);
                return;
            }
        }
        System.out.println(false);

    }

    static void fun(String str, String[] dict, String op){
        if(str.length()==0){
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            isPresent(dict,str.substring(0,i+1));
            fun(str.substring(i+1,str.length()),dict,str.substring(0,i+1));
        }
        return;
    }


    private static boolean isPresent(String[] dict, String substring) {
        for (int i = 0; i < dict.length; i++) {
            if (dict[i].equals(substring)){
                dict[i] = "";
                return true;
            }
        }
        return false;
    }
}
