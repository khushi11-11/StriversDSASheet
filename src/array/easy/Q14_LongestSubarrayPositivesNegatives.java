package array.easy;

import java.util.Arrays;
import java.util.HashMap;

/*
LONGEST SUBARRAY WITH GIVEN SUM K(POSITIVES)~
Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
Example 1:
Input Format: N = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.

Example 2:
Input Format: N = 3, k = 1, array[] = {-1, 1, 1}
Result: 3
Explanation: The longest subarray with sum 1 is {-1, 1, 1}. And its length is 3.
 */
public class Q14_LongestSubarrayPositivesNegatives {
    public static void main(String[] args) {
        int[] arr1 = {-1, 1, 1};
        int[] arr2 = {2,3,5};
        int k1 = 1;
        int k2 = 5;
        result(arr1, k1);
        result(arr2, k2);
    }

    static void result(int[] arr, int k) {
        int sum=0, maxLen=0;
        HashMap<Integer, Integer> map = new HashMap<>(); // key-prefix sum at index, value-index
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            // when prefix = target sum
            if (sum == k) maxLen = i+1;

            // sum-k = val which can be subtracted from the prefix sum to obtain target sum
            // if hashmap contains it -> it will become the prev_idx
            // prev_idx calculated for max length subarray
            if (map.containsKey(sum-k)) {
                int prev_idx = map.get(sum-k);
                // gets index value, fetch the index where that prefix sum occurred
                // this index = start of the subarray whose sum, ending at current index i, equals k.
                maxLen = Math.max(maxLen, i-prev_idx);
                // length fom current to the index where subarray started that sums up to give target sum
            }

            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }
        System.out.println(maxLen);
    }
}
