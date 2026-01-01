package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class DetectCycleInUndirectedGraph {

    static class Pair{
        int curr;
        int parent;

        public Pair(int curr, int parent) {
            this.curr = curr;
            this.parent = parent;
        }
    }

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
        System.out.println(bfs(1,adjList,n));
    }
    static boolean bfs(int startNode, ArrayList<ArrayList<Integer>> adjList, int n){
        boolean[] vis = new boolean[n+1];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(startNode,0));
        vis[startNode] = true;
        vis[0] = true;
        while (!q.isEmpty()){
            int curNode = q.peek().curr;
            int parNode = q.peek().parent;
            q.poll();
            for(int num : adjList.get(curNode)){
                if(vis[num] && num!=parNode) return true;
                if(!vis[num]){
                    q.add(new Pair(num,curNode));
                    vis[num] = true;
                }
            }
        }
        return false;
    }

    static boolean dfs(int startNode, ArrayList<ArrayList<Integer>> adjList, boolean[] vis, int n, int parentNode){
        vis[startNode] = true;
        for(int num : adjList.get(startNode)){
            if(num==startNode) return true;
            if(!vis[num]) dfs(num,adjList,vis,n,parentNode);
        }
        return false;
    }
}
