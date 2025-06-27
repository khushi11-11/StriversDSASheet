package array.medium;

import java.util.Arrays;

/*
LONGEST CONSECUTIVE SEQUENCE IN AN ARRAY~
Problem Statement: You are given an array of ‘N’ integers. You need to find the length of the longest sequence which contains the consecutive elements.
Example 1:
Input: [100, 200, 1, 3, 2, 4]
Output: 4
Explanation: The longest consecutive subsequence is 1, 2, 3, and 4.
Input: [3, 8, 5, 7, 6]
Output: 4
Explanation: The longest consecutive subsequence is 5, 6, 7, and 8.
 */
public class Q10_LongestSubsequence {
    public static void main(String[] args) {
        int[] arr1 = {100, 200, 1, 3, 2, 4};
        int[] arr2 = {3, 8, 5, 7, 6};
        bruteForce(arr1);
        bruteForce(arr2);
    }
    static void bruteForce(int[] nums) {
        Arrays.sort(nums);
        int ptr=1;
        int count=1, max=0;
        while (ptr < nums.length) {
            if (nums[ptr] == nums[ptr-1]){ //comparing curr element(ptr=1) to prev one(ptr-1=0)
                ptr++; // skip duplicates
            }
            else if (nums[ptr] == nums[ptr-1]+1) {
                count++;
                max=Math.max(max,count);
                ptr++;
            } else {
                count=1; // reset counter
                ptr++;
            }
        }
        System.out.println(max);
    }
}
