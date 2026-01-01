package A_PracticeLCS;

public class PrintingMatrix {
    static int memoLen;
    static int[][] memo;
    public static void main(String[] args) {

    }

    static void PrintingMatrix(String s1, String s2){
        if(memoLen==0) return;
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                if(memo[i][j]==memoLen){
                    int x=i,y=j;
                    StringBuilder lcs = new StringBuilder();
                    while (x>0 && y>0 && memo[x][y]>0){
                        lcs.append(s1.charAt(i));
                        x--;
                        y--;
                    }
                    System.out.println(lcs);
                    return;
                }
            }

        }
    }
}
