package array.easy;

import java.util.ArrayList;

/*
LONGEST SUBARRAY WITH GIVEN SUM K(Positives)
Problem Statement: Given an array and a sum k, we need to print the length of the longest subarray that sums to k.
Example 1:
Input Format: N(length) = 3, k = 5, array[] = {2,3,5}
Result: 2
Explanation: The longest subarray with sum 5 is {2, 3}. And its length is 2.
Example 2:
Input Format: N = 5, k = 10, array[] = {2,3,5,1,9}
Result: 3
Explanation: The longest subarray with sum 10 is {2, 3, 5}. And its length is 3.
 */
public class Q13_LongestSubarrayPositives {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5};
        int[] arr2 = {2,3,5,1,9};
        int[] arr3 = {10, 5, 2, 7, 1, 9};
        int[] arr4 = {-3, 2, 1};
        int k1 = 5;
        int k2 = 10;
        int k3 = 15;
        int k4 = 6;
        int len = arr1.length;
        System.out.println(subarray(arr4, len, k4));
    }
    static int subarray(int[] ar, int len, int k) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int sum=0;
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = i; j < len; j++) {
                if (sum < k) {
                    sum += ar[j];
                    arr.add(ar[j]);
                } else if (sum == k && arr.size()>sub.size()) {
                    sub.clear();
                    sub.addAll(arr);
                }
            }
        }
        return sub.size();
    }
}
