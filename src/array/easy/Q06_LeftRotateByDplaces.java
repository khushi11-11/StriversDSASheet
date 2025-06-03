package array.easy;

import java.util.Arrays;

/*
LEFT ROTATE ARRAY BY K PLACES~
Problem Statement: Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.
Examples:
Input: nums = [1, 2, 3, 4, 5, 6], k = 2
Output: nums = [3, 4, 5, 6, 1, 2]
Explanation: rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]

Input: nums = [3, 4, 1, 5, 3, -5], k = 8
Output: nums = [1, 5, 3, -5, 3, 4]
Explanation: rotate 1 step to the left: [4, 1, 5, 3, -5, 3]
rotate 2 steps to the left: [1, 5, 3, -5, 3, 4]
rotate 3 steps to the left: [5, 3, -5, 3, 4, 1]
rotate 4 steps to the left: [3, -5, 3, 4, 1, 5]
rotate 5 steps to the left: [-5, 3, 4, 1, 5, 3]
rotate 6 steps to the left: [3, 4, 1, 5, 3, -5]
rotate 7 steps to the left: [4, 1, 5, 3, -5, 3]
 */
public class Q06_LeftRotateByDplaces {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5, 6};
        int k1=2;
        int[] arr2 = {3, 4, 1, 5, 3, -5};
        int k2=8;
        int[] ans = rotateByK(arr2, k2);
        System.out.println(Arrays.toString(ans));
    }

    static int[] rotateByK(int[] arr, int k) {
        while(k!=0) {
            int temp = arr[0];
            for (int i = 0; i < arr.length-1; i++) {
                arr[i]=arr[i+1];
            }
            arr[arr.length-1] = temp;
            k--;
        }
        // putting a while loop for n-rotations
        return arr;
    }
}
