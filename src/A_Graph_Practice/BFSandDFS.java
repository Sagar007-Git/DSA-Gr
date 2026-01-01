package A_Graph_Practice;

import java.util.*;

public class BFSandDFS {
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
//        dfs(adjList,1,vis);
        System.out.println();
        bfs(adjList,1,vis);


    }

    static void dfs(ArrayList<ArrayList<Integer>> adjList, int node, boolean[] vis){
        vis[node] = true;
        System.out.print(node+" ");
        for (int val : adjList.get(node)){
            if(!vis[val]) dfs(adjList, val, vis);
        }
    }

    static void bfs(ArrayList<ArrayList<Integer>> adjList, int node, boolean[] vis){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        System.out.print(node+" ");
        while (!q.isEmpty()){
            int num = q.poll();
            for (int val : adjList.get(num)){
                if(!vis[val]){
                    q.add(val);
                    vis[val] = true;
                    System.out.print(val+" ");
                }
            }
        }

/*

10 13

1 3
1 2
3 5
3 4
2 4
2 6
4 10
4 8
2 7
6 7
7 8
8 9
8 10

*/

    }
}
