package Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class DetectCycleInDirectedGraph {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        boolean[] vis = new boolean[n+1];
        boolean patVis[] = new boolean[n+1];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
        }
        System.out.println();
        for (int i = 1; i <=n ; i++) {
            if(!dfs(i,vis,patVis,adjList)) {
                System.out.print(i+" ");
            };;
        }


    }

    private static boolean dfs(int node, boolean[] vis, boolean[] patVis, ArrayList<ArrayList<Integer>> adjList) {
        vis[node] = true;
        patVis[node] = true;

        for(int num : adjList.get(node)){
            if(!vis[num]){
                if(dfs(num,vis,patVis, adjList)) return true;
            }else if (patVis[num]) return true;
        }
        patVis[node] =false;
        return false;
    }


}
