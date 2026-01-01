package A_Graph_Practice;

import java.util.*;

public class KahnsAlgo {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[] inDgr = new int[n+1];
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            inDgr[v]++;
            adjList.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();
        for (int i = 0; i <=n; i++) {
            if(inDgr[i]==0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()){
            int node = q.poll();
            topo.add(node);
            for(int num : adjList.get(node)){
                inDgr[num]--;
                if(inDgr[num]==0) {
                    q.add(num);

                };
            }
        }
        for(int val : topo) System.out.print(val+" ");

    }
}
