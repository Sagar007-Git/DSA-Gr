package Graphs;

import java.util.*;

public class Topological_DFS_Sort {
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
        }
        boolean[] vis = new boolean[n+1];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i <=n; i++) {
            if(!vis[i]) dfs(adjList, vis, i, stack);
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop()+" ");
        }

    }
    static void dfs(ArrayList<ArrayList<Integer>> adjList, boolean[] vis, int node, Stack<Integer> stack){
        vis[node]= true;
        for(int num : adjList.get(node)){
            if(!vis[num]) dfs(adjList,vis, num, stack);
        }
        stack.add(node);

    }
}
