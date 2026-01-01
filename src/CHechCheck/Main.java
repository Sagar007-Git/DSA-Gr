package CHechCheck;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Number of snacks
        int[] nums = new int[N]; // Deliciousness values of snacks
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        System.out.println(solve(N, nums));
    }

    public static long solve(int N, int[] nums) {
        // TreeMap to store the maximum sum of strictly increasing subsequences ending at each value
        TreeMap<Integer, Long> map = new TreeMap<>();
        long maxSum = 0;

        for (int i = 0; i < N; i++) {
            // Find the maximum sum for all keys less than nums[i]
            Map.Entry<Integer, Long> entry = map.lowerEntry(nums[i]);
            long currentSum = nums[i];
            if (entry != null) {
                currentSum += entry.getValue();
            }

            // Update the maximum sum for nums[i]
            map.put(nums[i], Math.max(map.getOrDefault(nums[i], 0L), currentSum));

            // Remove any entries with keys greater than or equal to nums[i] but with smaller or equal sums
            while (true) {
                Map.Entry<Integer, Long> higherEntry = map.higherEntry(nums[i]);
                if (higherEntry == null || higherEntry.getValue() > currentSum) {
                    break;
                }
                map.remove(higherEntry.getKey());
            }

            // Update the overall maximum sum
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
