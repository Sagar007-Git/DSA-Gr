package A_Graph_Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class NumberOfProvinces {
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
        boolean[] vis = new boolean[n+1];
        int count=0;
        for (int i = 1; i <=n; i++) {
            if(!vis[i]) {
                dfs(adjList, i, vis);
                count++;
            };
        }
        System.out.println(count);

    }

    static void dfs(ArrayList<ArrayList<Integer>> adjList, int node, boolean[] vis){
        vis[node] = true;
        for (int val : adjList.get(node)){
            if(!vis[val]) dfs(adjList, val, vis);
        }
    }
}
