package A_Graph_Practice;

import java.util.ArrayList;
import java.util.Scanner;

public class CycleInUnDirGraph {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
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
        boolean[] vis = new boolean[n+1];

        for (int i = 1; i <=n; i++) {
            if(!vis[i] && dfs(adjList, vis, i, -1)) {
                System.out.println(true);
                return;
            };
        }
        System.out.println(false);
        return;
    }

    static boolean dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, int node, int parNode){
        vis[node] = true;
        for(int num : adjList.get(node)){
            if(!vis[num]){
                if(dfs(adjList, vis, num, node)) return true;
            }else if(num!=parNode) return true;
        }
        return false;
    }
}
