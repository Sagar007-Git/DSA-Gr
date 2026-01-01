package Graphs;

import java.util.*;

public class ShortestPath {

    static class Pair{
        int node;
        int wt;
        public Pair(int node, int wt) {
            this.node = node;
            this.wt = wt;
        }
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Pair>> adjList = new ArrayList<>(n+1);
        int[] in = new int[n+1];
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            int wt = scan.nextInt();
            in[v]++;
            adjList.get(u).add(new Pair(v,wt));
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <=n; i++) {
            if(in[i]==0) q.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int node = q.poll();
            res.add(node);
            for (Pair pair : adjList.get(node)){
                in[pair.node]--;
                if(in[pair.node]==0) q.add(pair.node);
            }
        }
        for (int i = 0; i <=n; i++) Arrays.fill(in, Integer.MAX_VALUE-2);
        in[0] = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(res.removeFirst(), 0));
        while (!queue.isEmpty()){
            Pair node = queue.poll();
            int u = node.node;
            int wt = node.wt;
            for(Pair p : adjList.get(u)){
                if(in[p.node]>wt+p.wt){
                    in[p.node] = wt+p.wt;
                    queue.add(new Pair(p.node,wt+p.wt));
                }
            }
        }
        System.out.println(Arrays.toString(in));

    }
}
