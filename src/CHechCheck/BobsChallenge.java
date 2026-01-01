package CHechCheck;

import java.util.*;

public class BobsChallenge {

    public static void main(String[] args) {
        // Example input
        int N = 74;
        int[] nums = {542692413, 431289040, 751517587, 36263053, 153653087, 473978623, 359295400, 498538404, 249407871, 125490925, 326410002, 68444699, 915685133, 312134485, 158237048, 310587142, 301859367, 670843317, 715111823, 949340977, -756468392, 658898446, 384961553, 292823350, -13044556, 228396630, 988225135, 934848973, 228730979, 504556161, 827421405, 255009564, 770780264, 221633515, 935058705, 453798410, 997428023, 563526172, 16266152, 887191607, 777403006, 991110236, 832054890, 888790760, 247795414, 708830345, 536852241, 958815158, 950105212, 91312661, 373043854, 163574484, 217474524, -157855783, 83107236, 491983564, 812575164, 288877309, -779466209, 974730139, 452798806, 644540211, 615845063, 414682629, -495690378, 706991250, -115979072, 257012690, 158598420, 552758541, 802051495, 823058099, 89895444, 210471808};

        // Solve the problem
        long maxReward = solve(N, nums);

        // Print the result
        System.out.println("Maximum possible reward: " + maxReward);
    }
    public static long solve(int N, int[] arr) {
        if (N == 1) {
            return arr[0];
        }

        // Step 2: Sort the array
        Arrays.sort(arr);

        // Step 3: Compute the sum based on the nature of the array
        long sum = 0;

        if (arr[0] < 0 && arr[N - 1] < 0) {
            // Case 1: All elements are negative
            sum = arr[N - 1]; // Start with the largest (least negative) value
            for (int i = N - 2; i >= 0; i--) {
                sum -= arr[i]; // Subtract the rest
            }
        } else {
            // Case 2: Mixed or all positive numbers
            for (int i = 0; i < N; i++) {
                if (arr[i] < 0) {
                    sum += (-arr[i]); // Add absolute value of negative numbers
                } else {
                    sum += arr[i]; // Add positive numbers
                }
            }
        }

        return sum;

        }
    }

