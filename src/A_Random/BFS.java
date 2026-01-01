package A_Random;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n  = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i=0; i<=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i <m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(v).add(u);
            adjList.get(u).add(v);
        }

        for (int i = 0; i <=n; i++) {
            System.out.print("Vertex "+i+" : ");
            System.out.println(adjList.get(i));
        }
        bfs(adjList,1,n);

    }

    static void bfs(ArrayList<ArrayList<Integer>> adjList, int startNode, int n){
        boolean[] vis = new boolean[n+1];
        vis[0]  = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        vis[startNode] = true;
        System.out.print(startNode+" ");
        while (!q.isEmpty()){
            int node = q.poll();
            for(int val : adjList.get(node)){
                if(!vis[val]){
                    q.add(val);
                    vis[val] = true;
                    System.out.print(val+" ");
                }
            }
        }
    }
}
