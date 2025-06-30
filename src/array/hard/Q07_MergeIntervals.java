package array.hard;

import java.util.*;
/*
MERGE OVERLAPPING SUB-INTERVALS ~
Problem Statement: Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.
Example 1:
Input: intervals=[[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
 intervals.
Example 2:
Input: [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Since intervals [1,4] and [4,5] are overlapping we can merge them to form [1,5].

*overlapping here means if the upper bound value of a member array X1 is >= lower bound value of another member array X2, where index(X1) < index(X2)
 */
public class Q07_MergeIntervals {
    public static void main(String[] args) {
        int[][] test1 = {{1,3}, {2,6}, {8,10}, {15,18}};
        int[][] test2 = {{1,4}, {1,5}};
        brute(test1);
    }
    static void brute(int[][] nums) {
        // edge case: when array size is small enough
        if (nums.length <= 1) {
            for (int[] i : nums) {
                System.out.println(Arrays.toString(i));
            }
            return;
        }

        // Step 1: Sort intervals based on starting times
        // Arrays.sort(nums); gives error for 2D arrays
        // Solution: Use a custom comparator - lambda
        Arrays.sort(nums, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>(); // new list - merged intervals
        int[] current = nums[0]; // current member array

        // step 2: Merge potential intervals
        for (int i = 1; i < nums.length; i++) {
            int[] next = nums[i]; // loop started from 1, current already set to 0th array, next resets in every iteration

            // If overlapping, merge them
            if (current[1] >= next[0]) {
                current[1] = Math.max(current[1], next[1]);
            } else {
                merged.add(current); // if not just add the current non-overlapping interval
                current = next; // incr ptr current to next array
            }
        }

        // Add the last interval
        merged.add(current);

        // Print merged intervals
        System.out.print("[");
        for (int[] interval : merged) {
            System.out.print(Arrays.toString(interval) + ",");
        }
        System.out.print("]");
    }
}
