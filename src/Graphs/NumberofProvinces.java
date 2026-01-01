package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class NumberofProvinces {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] mat = new int[n][n];

        for (int i = 0; i <n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = scan.nextInt();
            }
        }
        System.out.println(fun(mat));;

    }
    static int fun(int[][] mat){
        int n = mat.length;
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i!=j && mat[i][j]==1){
                    adjList.get(i+1).add(j+1);
                }
            }
        }
        int i=0;
        for(ArrayList<Integer> list : adjList){
            System.out.print("Vertex "+(i)+" : ");
            System.out.println(list);
            i++;
        }

        boolean[] vis = new boolean[n+1];
        vis[0] = true;
        int startNode = 1;
        int count=0;
        for (int j = 1; j < vis.length; j++) {
            if(!vis[j]){
                count++;
                dfs(startNode, vis,adjList);
//                bfs(j, vis, adjList);
            }
        }
        return count;
    }

    private static void bfs(int startNode, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        vis[startNode] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            for(int num : adjList.get(node)){
                if(!vis[num]){
                    vis[num] = true;
                    q.add(num);
                }
            }
        }
    }

    private static void dfs(int startNode, boolean[] vis, ArrayList<ArrayList<Integer>> adjList) {
        vis[startNode] = true;
        for(int num : adjList.get(startNode)){
            if (!vis[num]) {
                dfs(num, vis, adjList);
            }
        }
    }
}
