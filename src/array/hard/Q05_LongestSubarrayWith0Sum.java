package array.hard;

import java.util.HashMap;

/*
LENGTH OF THE LONGEST SUBARRAY WITH ZERO SUM ~
Problem Statement: Given an array containing both positive and negative integers, we have to find the length of the longest subarray with the sum of all elements equal to zero.

Example 1:
Input Format: N = 6, array[] = {9, -3, 3, -1, 6, -5}
Result: 5
Explanation: The following subarrays sum to zero:
{-3, 3} , {-1, 6, -5}, {-3, 3, -1, 6, -5}
Since we require the length of the longest subarray, our answer is 5!

Example 2:
Input Format: N = 8, array[] = {6, -2, 2, -8, 1, 7, 4, -10}
Result: 8
Subarrays with sum 0 : {-2, 2}, {-8, 1, 7}, {-2, 2, -8, 1, 7}, {6, -2, 2, -8, 1, 7, 4, -10}
Length of longest subarray = 8

Example 3:
Input Format: N = 3, array[] = {1, 0, -5}
Result: 1
Subarray : {0}
Length of longest subarray = 1

Example 4:
Input Format: N = 5, array[] = {1, 3, -5, 6, -2}
Result: 0
Subarray: There is no subarray that sums to zero
 */
public class Q05_LongestSubarrayWith0Sum {
    public static void main(String[] args) {
        int[] test1 = {9, -3, 3, -1, 6, -5};
        int[] test2 = {6, -2, 2, -8, 1, 7, 4, -10};
        int[] test3 = {1, 0, -5};
        int[] test4 = {1, 3, -5, 6, -2};
        solution(test1);
        optimal(test2);
        optimal(test3);
        optimal(test4);
    }

    static void solution(int[] nums) {
        int len=0;
        for (int i = 0; i < nums.length; i++) {
            int sum=0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == 0) {
                    len = Math.max(len, j-i+1);
                }
            }
        }
        System.out.println(len);
    }
    static void optimal(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int prefix=0, max_len =0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            // target found
            if (prefix==0) max_len = i+1;
            // target not found
            if (!map.containsKey(prefix)) { // sum encountered first time
                map.put(prefix,i);
            } else { // seen the same sum earlier
                int prev_idx = map.get(prefix);
                max_len = Math.max(max_len, i-prev_idx);
            }
        }
        System.out.println(max_len);
    }
}














