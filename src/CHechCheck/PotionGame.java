package CHechCheck;

import java.util.*;

public class PotionGame {

    public static int solve(int N, int[] potions) {
        // Create a DP array to store the maximum health achievable from each position
        int[] dp = new int[N + 1];

        // Initialize the DP array for the base case (no potions left)
        dp[N] = 0;

        // Precompute the suffix sum of the potions array
        int[] suffixSum = new int[N + 1];
        suffixSum[N] = 0;
        for (int i = N - 1; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + potions[i];
        }

        // Fill the DP array from the end to the start
        for (int i = N - 1; i >= 0; i--) {
            // Option 1: Take one potion
            int option1 = potions[i] + (suffixSum[i + 1] - dp[i + 1]);

            // Option 2: Take two potions (if possible)
            int option2 = Integer.MIN_VALUE;
            if (i + 1 < N) {
                option2 = potions[i] + potions[i + 1] + (suffixSum[i + 2] - dp[i + 2]);
            }

            // Choose the maximum of the two options
            dp[i] = Math.max(option1, option2);
        }

        // The answer is stored in dp[0]
        return dp[0];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Read the number of potions
        int N = sc.nextInt();

        // Read the potions array
        int[] potions = new int[N];
        for (int i = 0; i < N; i++) {
            potions[i] = sc.nextInt();
        }

        // Compute and print the result
        int result = solve(N, potions);
        System.out.println(result);

        sc.close();
    }
}