package Jan_week_1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFSImpl {
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
        BFS(adjList, 4, n);

    }
    public static void BFS(ArrayList<ArrayList<Integer>> adjList, int source, int nodes){
        boolean[] vis = new boolean[nodes+1];
        vis[source] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(source);
        while (!q.isEmpty()){
            int node = q.poll();
            System.out.print(node + " ");
            for(int num : adjList.get(node)){
                if(!vis[num]) {
                    q.add(num);
                    vis[num] = true;
                }
            }
        }
    }
}
