package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologicalSort {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        int[] inDegree = new int[n+1];
        for (int i = 0; i < m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();
            inDegree[v]++;
            adjList.get(u).add(v);
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i <=n; i++) {
            if(inDegree[i]==0) q.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!q.isEmpty()){
            int i = q.poll();
            res.add(i);
            for(int num : adjList.get(i)){
                if(inDegree[num]>0){
                    inDegree[num]--;
                    if(inDegree[num]==0) q.add(num);
                }
            }
        }
        if(res.size()==n+1){
            System.out.print("Topological Sort order : ");
            for (int num : res) System.out.print(num +" ");
        }else{
            System.out.println("Graph has a Cycle! Cannot have topological order");
        }

    }
}
