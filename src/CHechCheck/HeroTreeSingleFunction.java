package CHechCheck;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.*;

public class HeroTreeSingleFunction {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);

        // Read the number of nodes
        int n = Integer.parseInt(br.readLine().trim());

        // Read the edges
        int[][] edges = new int[n - 1][3];
        for (int i = 0; i < n - 1; i++) {
            String[] arr_edges = br.readLine().trim().split(" ");
            if (arr_edges.length < 3) {
                throw new IllegalArgumentException("Each edge must have 3 values: u, v, p");
            }
            for (int j = 0; j < 3; j++) {
                edges[i][j] = Integer.parseInt(arr_edges[j]);
            }
        }

        // Read the number of queries
        int q = Integer.parseInt(br.readLine().trim());

        // Read the queries
        long[][] queries = new long[q][2];
        for (int i = 0; i < q; i++) {
            String[] arr_queries = br.readLine().trim().split(" ");
            if (arr_queries.length < 2) {
                throw new IllegalArgumentException("Each query must have 2 values: u, H");
            }
            for (int j = 0; j < 2; j++) {
                queries[i][j] = Long.parseLong(arr_queries[j]);
            }
        }

        // Solve the problem
        int[] out_ = solve(n, edges, q, queries);

        // Print the results
        System.out.print(out_[0]);
        for (int i = 1; i < out_.length; i++) {
            System.out.print(" " + out_[i]);
        }

        wr.close();
        br.close();
    }

    static int[] solve(int n, int[][] e, int q, long[][] qs) {
        // Step 1: Build the tree
        List<List<int[]>> t = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            t.add(new ArrayList<>());
        }

        for (int[] edge : e) {
            int u = edge[0];
            int v = edge[1];
            int p = edge[2];
            t.get(u).add(new int[]{v, p});
            t.get(v).add(new int[]{u, p});
        }

        // Step 2: Assign parents and powers using BFS
        int[] par = new int[n + 1];
        int[] pow = new int[n + 1];
        boolean[] vis = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1); // Root is node 1
        vis[1] = true;

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (int[] edge : t.get(u)) {
                int v = edge[0];
                int p = edge[1];
                if (!vis[v]) {
                    vis[v] = true;
                    par[v] = u;
                    pow[v] = p;
                    queue.add(v);
                }
            }
        }

        // Step 3: Precompute binary lifting data
        int LOG = 20; // log2(10^5) is approximately 17
        int[][] up = new int[n + 1][LOG]; // up[u][k] = 2^k-th ancestor of u
        long[][] cum = new long[n + 1][LOG]; // cum[u][k] = cumulative power from u to 2^k-th ancestor

        for (int u = 1; u <= n; u++) {
            up[u][0] = par[u];
            cum[u][0] = pow[u];
        }

        for (int k = 1; k < LOG; k++) {
            for (int u = 1; u <= n; u++) {
                up[u][k] = up[up[u][k - 1]][k - 1];
                cum[u][k] = cum[u][k - 1] + cum[up[u][k - 1]][k - 1];
            }
        }

        // Step 4: Process each query
        int[] res = new int[q];
        for (int i = 0; i < q; i++) {
            int u = (int) qs[i][0];
            long H = qs[i][1];

            // Traverse the path from u to the root using binary lifting
            int ans = u;
            long health = H;

            for (int k = LOG - 1; k >= 0; k--) {
                if (up[ans][k] != 0 && cum[ans][k] <= health) {
                    health -= cum[ans][k];
                    ans = up[ans][k];
                }
            }

            res[i] = ans;
        }

        return res;
    }
}