package CHechCheck;

import java.util.*;

public class SkyscraperGreenery {
    public static int[] solve(int N, int K, int Q, int[] A, int[] q) {
        // Step 1: Initialize data structures
        List<Integer> pos = new ArrayList<>(); // To store positions of skyscrapers
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder()); // Max heap for segment lengths
        Map<Integer, Integer> cnt = new HashMap<>(); // To track counts of segment lengths
        int[] res = new int[N]; // To store max segment lengths after each skyscraper

        // Add boundaries to the positions list
        pos.add(0);
        pos.add(K);

        // Add the initial segment length to the max heap and count map
        heap.add(K);
        cnt.put(K, 1);

        // Step 2: Process each skyscraper
        for (int i = 0; i < N; i++) {
            int p = A[i];

            // Find the insertion index for the current position using binary search
            int idx = Collections.binarySearch(pos, p);
            if (idx < 0) {
                idx = -(idx + 1); // Convert to insertion point
            }

            // Get the neighbors (left and right positions)
            int l = pos.get(idx - 1);
            int r = pos.get(idx);

            // Remove the old segment (r - l) from the heap and count map
            int oldLen = r - l;
            cnt.put(oldLen, cnt.get(oldLen) - 1);
            if (cnt.get(oldLen) == 0) {
                cnt.remove(oldLen);
            }

            // Add the new segments (p - l) and (r - p) to the heap and count map
            int len1 = p - l;
            heap.add(len1);
            cnt.put(len1, cnt.getOrDefault(len1, 0) + 1);

            int len2 = r - p;
            heap.add(len2);
            cnt.put(len2, cnt.getOrDefault(len2, 0) + 1);

            // Insert the current position into the positions list
            pos.add(idx, p);

            // Update the heap to remove invalid lengths
            while (!heap.isEmpty() && !cnt.containsKey(heap.peek())) {
                heap.poll();
            }

            // Store the current maximum segment length in the result array
            res[i] = heap.isEmpty() ? 0 : heap.peek();
        }

        // Step 3: Process queries
        int[] ans = new int[Q];
        for (int i = 0; i < Q; i++) {
            int qIdx = q[i];
            ans[i] = res[qIdx - 1]; // q[i] is 1-based index
        }

        return ans;
    }

    public static void main(String[] args) {
        // Example input
        int N = 3, K = 100, Q = 3;
        int[] A = {42, 55, 19};
        int[] q = {1, 2, 1};

        // Solve the problem
        int[] output = solve(N, K, Q, A, q);

        // Print the result
        System.out.println(Arrays.toString(output)); // Expected output: [58, 45, 58]
    }
}