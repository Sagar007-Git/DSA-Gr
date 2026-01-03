package Jan_week_1;

import java.util.Scanner;

public class ImpleAdjMatrix {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int[][] mat = new int[n][n];
        int m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            mat[u-1][v-1] = 1;
            mat[v-1][u-1] = 1;
        }
        System.out.print("  ");
        for (int i = 0; i < n; i++) {
            System.out.print(i+1 +" ");
        }
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print(i+1+" ");
            for (int j = 0; j < n; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
// 1 based node indexing

//        4
//        4

//        1 2
//        1 4
//        2 4
//        4 3

//        1 2 3 4
//        1 0 1 0 1
//        2 1 0 0 1
//        3 0 0 0 1
//        4 1 1 1 0