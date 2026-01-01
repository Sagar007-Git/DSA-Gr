package Graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BFS {
    public static void main(String[] args) {
        Scanner scan  = new Scanner(System.in);
        int n = scan.nextInt();
        int m = scan.nextInt();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>(n+1);
        for (int i = 0; i <=n; i++) adjList.add(new ArrayList<>());
        for (int i = 0; i <m; i++) {
            int u = scan.nextInt();
            int v = scan.nextInt();

            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }
        int i  =0;
        for(ArrayList<Integer> list : adjList){
            System.out.print("Vertex "+i+" : ");
            System.out.println(list);
            i++;
        }
        fun(1,adjList,n);
    }

    static void fun(int startNode, ArrayList<ArrayList<Integer>> adjList, int n){
        boolean[] arr = new boolean[n+1];
        Queue<Integer> q = new LinkedList<>();
        q.add(startNode);
        arr[startNode] = true;
        while (!q.isEmpty()){
            int node = q.poll();
            System.out.print(node+" ");
            for(int num : adjList.get(node)){
                if(!arr[num]){
                    arr[num] = true;
                    q.add(num);
                }
            }
        }
        /*8 11
            1 2
            1 3
            2 4
            2 6
            3 4
            3 8
            3 7
            4 5
            5 8
            5 7
            5 6*/
    }
}
