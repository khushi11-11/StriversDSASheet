package array.hard;

import java.util.HashMap;

/*
COUNT THE NUMBER OF SUBARRAYS WITH GIVEN XOR K ~
Problem Statement: Given an array of integers A and an integer B. Find the total number of subarrays having bitwise XOR of all elements equal to k.

Example 1:
Input Format: A = [4, 2, 2, 6, 4] , k = 6
Result: 4
Explanation: The subarrays having XOR of their elements as 6 are  [4, 2], [4, 2, 2, 6, 4], [2, 2, 6], [6]

Example 2:
Input Format: A = [5, 6, 7, 8, 9], k = 5
Result: 2
Explanation: The subarrays having XOR of their elements as 5 are [5] and [5, 6, 7, 8, 9]
 */
public class Q06_CountSubarraysWithXORk {
    public static void main(String[] args) {
        int[] test1 = {4,2,2,6,4};
        int k1 = 6;
        int[] test2 = {5,6,7,8,9};
        int k2 = 5;
        solution(test1, k1);
        solution(test2, k2);
    }
    static void solution(int[] nums, int k) {
        int count=0, xor=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        // instead of putting index, we will put freq bcoz we want to know how many times certain value has occurred and not where it occurred
        for (int num : nums) {
            // xor^nums[i]=k <=> nums[i]=xor^k
            xor ^= num;
            // counter incremented
            if (xor == k) count++;
            //  if there were multiple (and not just 1) prefixes giving the required XOR
            if (map.containsKey(xor ^ k)) count += map.getOrDefault(xor ^ k, 0);
            // store how many times this XOR value has occurred so far, instead of storing index
            if (!map.containsKey(xor ^ k)) map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        System.out.println(count);
    }
}
