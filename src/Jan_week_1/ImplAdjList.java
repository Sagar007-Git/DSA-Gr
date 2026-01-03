package Jan_week_1;

import java.util.ArrayList;
import java.util.Scanner;

public class ImplAdjList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int i=0;
        for(ArrayList list : adjList) System.out.println(i++ +" -> "+list);
    }
}

//        4
//        4

//        1 2
//        1 4
//        2 4
//        4 3

//        0 -> []
//        1 -> [2, 4]
//        2 -> [1, 4]
//        3 -> [4]
//        4 -> [1, 2, 3]