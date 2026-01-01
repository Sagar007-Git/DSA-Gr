package Graphs;

import java.lang.reflect.Array;
import java.util.*;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;

public class BipartiteGraph {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] color = new int[n+1];
        Arrays.fill(color,-1);
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n ; i++)adjList.add(new ArrayList<>());
        for (int i = 0; i <m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        System.out.println();
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        color[1] = 0;
        while (!q.isEmpty()){
            int node = q.poll();
            for(int num : adjList.get(node)){
                if(color[num]==-1) {
                    color[num] = 1 - color[node];
                    q.add(num);
                }
                else if(color[num]==color[node]) {
                    for (int i = 0; i <=n; i++) System.out.print(color[i]+" ");
                    System.out.println(false);
                    return;
                }

            }
        }
        for (int i = 0; i <=n; i++) System.out.print(color[i]+" ");
        System.out.println(true);

    }
}
