package array.daily;

import java.util.ArrayList;
import java.util.Map;

/*
KADANE'S ALGORITHM : MAXIMUM SUBARRAY SUM IN AN ARRAY~
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
has the largest sum and returns its sum and prints the subarray.
Example 1:
Input: arr = [-2,1,-3,4,-1,2,1,-5,4] 
Output: 6 
Explanation: [4,-1,2,1] has the largest sum = 6. 
Examples 2: 
Input: arr = [1] 
Output: 1 
Explanation: Array has only one element and which is giving positive sum of 1.

NOTE : Kadane's algorithm is an optimal approach to find out a Barry out of an original Aarey, which has the largest sum possible. It is not a problem statement button approach
 */
public class KadanesAlgo {
    public static void main(String[] args) {
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        result(arr1);
    }

    static void result(int[] arr) {
        int curr_sum=arr[0];
        int max_so_far=arr[0];
        for (int i : arr) {
            curr_sum = Math.max(curr_sum+i, i);
            max_so_far = Math.max(max_so_far, curr_sum);
        }
        System.out.println(max_so_far);
    }
}




















