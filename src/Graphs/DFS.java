package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i <m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int i  =0;
        for(ArrayList<Integer> list : adjList){
            System.out.print("Vertex "+i+" : ");
            System.out.println(list);
            i++;
        }
        boolean[] vis = new boolean[n+1];
        vis[0] = true;
        fun(1,adjList,vis);
    }

    static void fun(int u, ArrayList<ArrayList<Integer>> adjList, boolean[] vis){
        vis[u] = true;
        System.out.print(u+" ");
        for(int v : adjList.get(u)){
            if(!vis[v]){
                fun(v, adjList,vis);
            }
        }
    }
}

//        4 4

//        1 2
//        1 4
//        2 4
//        4 3

//        1 2 4 3