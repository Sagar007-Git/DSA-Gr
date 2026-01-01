package Practic;

import java.util.*;
import java.util.*;

public class Codehunt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        int Q = scanner.nextInt();

        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = scanner.nextInt();
        }

        int[] queries = new int[Q];
        for (int i = 0; i < Q; i++) {
            queries[i] = scanner.nextInt();
        }

        int[] result = solve(N, K, Q, A, queries);
        for (int res : result) {
            System.out.println(res);
        }
    }

    public static int[] solve(int N, int K, int Q, int[] A, int[] queries) {
        TreeSet<Integer> positions = new TreeSet<>();
        positions.add(0);
        positions.add(K);

        int[] maxSegment = new int[N + 1];
        maxSegment[0] = K;

        for (int i = 0; i < N; i++) {
            positions.add(A[i]);
            Integer lower = positions.lower(A[i]);
            Integer higher = positions.higher(A[i]);

            int prevSegment = higher - lower;
            int newSegment1 = A[i] - lower;
            int newSegment2 = higher - A[i];

            int currentMax = Math.max(newSegment1, newSegment2);
            maxSegment[i + 1] = Math.max(maxSegment[i], currentMax);
        }

        int[] result = new int[Q];
        for (int i = 0; i < Q; i++) {
            result[i] = maxSegment[queries[i]];
        }

        return result;
    }
}