package Graphs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class RepresentationList {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int i=0;
        for (ArrayList<Integer> list : adjList) {
            System.out.print("Vertex "+i+" : ");
            System.out.println(list);
            i++;
        }

    }
    
}
