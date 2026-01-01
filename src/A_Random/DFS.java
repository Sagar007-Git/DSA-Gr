package A_Random;

import java.io.FilterOutputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DFS {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n);
        for (int i = 0; i <=n ; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i <m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        for(int i=0; i<=n; i++){
            System.out.print("Vertex "+i+" : ");
            System.out.println(adjList.get(i));
        }
        boolean[] arr = new boolean[n+1];
        arr[0] = true;
        dfs(arr, adjList, 1);

    }
    static void dfs(boolean[] vis, ArrayList<ArrayList<Integer>> adjList, int startNode){
        vis[startNode] = true;
        System.out.print(startNode+" ");
        for (int val : adjList.get(startNode)){
            if(!vis[val]){
                dfs(vis,adjList,val);
            }
        }
    }
}
