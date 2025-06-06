package array.easy;

import java.util.ArrayList;
import java.util.Arrays;

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
public class Q13_LongestSubarray {
    public static void main(String[] args) {
        int[] arr1 = {2,3,5};
        int k = 5;
        int len = arr1.length;
        System.out.println(subarray(arr1, len, k));
    }
    static ArrayList<Integer> subarray(int[] ar, int len, int k) {
        ArrayList<Integer> sub = new ArrayList<>();
        for (int i = 0; i < ar.length; i++) {
            int sum=0;
            ArrayList<Integer> arr = new ArrayList<>();
            for (int j = i; j < ar.length; j++) {
                if (sum < k) {
                    sum += ar[j];
                    arr.add(ar[j]);
                } else if (sum == k && arr.size()>sub.size()) {
                    sub.clear();
                    sub.addAll(arr);
                }
            }
        }
        return sub;
    }
}
