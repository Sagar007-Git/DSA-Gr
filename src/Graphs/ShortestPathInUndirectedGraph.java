package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class ShortestPathInUndirectedGraph {
    static class Pair{
        int node;
        int wt;

        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(new Pair(v,1));
            adjList.get(v).add(new Pair(v,2));
        }


    }
}
