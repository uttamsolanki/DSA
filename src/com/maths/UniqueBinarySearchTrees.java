package com.maths;

import java.util.*;

public class UniqueBinarySearchTrees {
        public static int longestSubsequence(int[] feature1, int[] feature2) {
            int n = feature1.length;
            int[] dp = new int[n];

            // Initialize all dp values to 1 since a single element is a valid subsequence
            for (int i = 0; i < n; i++) {
                dp[i] = 1;
            }

            // Fill dp array
            for (int i = 0; i < n; i++) {
                for (int j = i + 1; j < n; j++) {
                    if ((feature1[i] > feature1[j] && feature2[i] > feature2[j]) ||
                            (feature1[i] < feature1[j] && feature2[i] < feature2[j])) {
                        dp[j] = Math.max(dp[j], dp[i] + 1);
                    }
                }
            }

            // Find the maximum value in dp array
            int maxLength = 1;
            for (int i = 0; i < n; i++) {
                maxLength = Math.max(maxLength, dp[i]);
            }

            return maxLength;
        }



    public static int maxAreaOfRectangles(int[] sidelength) {
        final long MOD = 1000000007;
        Arrays.sort(sidelength);
        int length = sidelength.length;
        long totalArea = 0;
        int[] pairsOf = new int[2];
        int pairIndex = 0;
        int index = length - 1;

        while (index > 0) {
            if (sidelength[index] - sidelength[index - 1] < 2) {
                pairsOf[pairIndex++] = sidelength[index - 1];
                index--;

                if (pairIndex == 2) {
                    totalArea = (totalArea + (pairsOf[0] * pairsOf[1]) % MOD) % MOD;
                    pairIndex = 0;
                }
            }
            index--;
        }

        return (int)totalArea;
    }
    public static int maxSumOfAreas(int[] sideLengths) {
        final int MOD = 1000000007;

        // Step 1: Count frequencies of each length
        Map<Integer, Integer> freq = new HashMap<>();
        for (int length : sideLengths) {
            freq.put(length, freq.getOrDefault(length, 0) + 1);
        }

        // Step 2: Adjust frequencies considering we can decrease any length by 1
        HashSet<Integer> set = new HashSet<>(freq.keySet());
        for (int length : set ) {
            if (freq.containsKey(length - 1)) {
                freq.put(length - 1, freq.get(length - 1) + freq.get(length));
            }
        }

        // Step 3: Sort the lengths by descending order
        List<Integer> lengths = new ArrayList<>(freq.keySet());
        Collections.sort(lengths, Collections.reverseOrder());

        // Step 4: Create rectangles
        List<Integer> availablePairs = new ArrayList<>();
        for (int length : lengths) {
            while (freq.get(length) >= 2) {
                availablePairs.add(length);
                freq.put(length, freq.get(length) - 2);
            }
        }

        // Step 5: Calculate area using the pairs
        long areas = 0;
        for (int i = 0; i < availablePairs.size() - 1; i += 2) {
            areas = (areas + (long) availablePairs.get(i) * availablePairs.get(i + 1) % MOD) % MOD;
        }

        return (int) areas;
    }



    public static void main(String[] args) {
        int[] feature1 = {3,2,1};
        int[] feature2 = {6,5,4};

        int result = longestSubsequence(feature1, feature2);
        System.out.println("Length of the longest subsequence free of outliers: " + result);

    }
}
