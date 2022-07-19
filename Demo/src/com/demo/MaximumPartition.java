package com.demo;

public class MaximumPartition {

    static int maxPartitions(int arr[], int n)
    {
        int ans = 0, max_so_far = 0;
        for (int i = 0; i < n; ++i) {

            // Find maximum in prefix arr[0..i]
            max_so_far = Math.max(max_so_far, arr[i]);

            // If maximum so far is equal to index, we can
            // make a new partition ending at index i.
            if (max_so_far == i)
                ans++;
        }
        return ans;
    }

    static int maxPartitions(int[] arr)
    {
        int N = arr.length;

        // To keep track of max
        // and min elements at every index
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];

        leftMax[0] = arr[0];

        for (int i = 1; i < N; i++) {
            leftMax[i] = Math.max(leftMax[i - 1], arr[i]);
        }

        rightMin[N - 1] = arr[N - 1];

        for (int i = N - 2; i >= 0; i--) {
            rightMin[i] = Math.min(rightMin[i + 1], arr[i]);
        }

        int count = 0;

        for (int i = 0; i < N - 1; i++) {
            if (leftMax[i] <= rightMin[i + 1]) {
                count++;
            }
        }

        // Return count + 1 as the final answer
        return count + 1;
    }
}
