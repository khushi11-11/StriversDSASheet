package array.medium;

import java.util.HashMap;

/*
COUNT SUBARRAY SUM EQUALS K~
Problem Statement: Given an array of integers and an integer k, return the total number of subarrays whose sum equals k.
Example 1:
Input Format: N = 4, array[] = {3, 1, 2, 4}, k = 6
Result: 2
Explanation: The subarrays that sum up to 6 are [3, 1, 2] and [2, 4].
Example 2:
Input Format: N = 3, array[] = {1,2,3}, k = 3
Result: 2
Explanation: The subarrays that sum up to 3 are [1, 2], and [3].
 */
public class Q14_SubarrayCount {
    public static void main(String[] args) {
        int[] arr1 = {3, 1, 2, 4};
        int k1 = 6;
        int[] arr2 = {1,2,3};
        int k2 = 3;
//        result(arr1,k1);
        result(arr2,k2);
    }

    static void result(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum=0, count=0;
        map.put(0, 1); // base case: to count subarrays starting from index 0
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i]; // calculate prefix at index i

            count += map.getOrDefault(sum-k, 0); // get freq of sum-k, if it exists add the freq (1,2,3,..) to count vble

            map.put(sum, map.getOrDefault(sum,0)+1); // updates freq. count of ggiven sum, basically gets incremented by 1 if already exists or adds up with freq 1 if does not exist
        }
        System.out.println(count);
    }
}
