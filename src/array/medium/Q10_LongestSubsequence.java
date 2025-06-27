package array.medium;

import java.util.Arrays;
import java.util.HashSet;

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
        int[] arr3 = {9, 1, -3, 2, 4, 8, 3, -1, 6, -2, -4, 7};

        int[] test1 = {10, 30, 20, 21, 22, 50};
        int[] test2 = {1, 2, 3, 4, 5, 100, 200, 3, 2, 1};
        int[] test3 = {5, 100, 4, 3, 2, 1, 6};
        optimal(test1);
        optimal(test2);
        optimal(test3);
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
    } // time=nlogn, space=n

    static void optimal(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int start=0, incr =1;
        int count=1, max=count;
        /*
        1. finding start point of a seq-> whose -1 does not exist
            2. when found -> start doesn't change, checks for next value (+1)
                2-a. if its successor exists -> seq+1, count+1, update max
                2-b. if successor not found (of seq-ptr) -> count=1, start gets updated to curr seq ptr
            3. if not found -> incr start, update seq ptr
         */
        while (start < nums.length){
            if (set.contains(nums[start]-1)) { // not start (-1 exists)
                start++;
            } else { // start is found
                // when seq is found -> count sequence inside if
                if (set.contains(nums[start]+incr)) { // incr= +1, +2, +3, ... so on
                    incr++;
                    count++;
                } else { // when seq ends
                    count=1;
                    incr=1;
                    start++;
                }
                max=Math.max(max,count); // updated calculation of count
            }
        }
        System.out.println(max);
    }
    static void optimal2(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int x : nums) set.add(x);
        int max=0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int current = num;
                int count = 1;

                while (set.contains(current + 1)) {
                    current++;
                    count++;
                }

                max = Math.max(max, count);
            }
        }
        System.out.println(max);
    }
}
