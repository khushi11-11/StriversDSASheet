package array.easy;

import java.util.Arrays;

/*
MOVE ZEROS TO END~
Problem Statement: You are given an array of integers, your task is to move all the zeros in the array to the end of the array and move non-negative integers to the front by maintaining their order.

Examples:
Input: nums = [0, 1, 4, 0, 5, 2]
Output: [1, 4, 5, 2, 0, 0]
Explanation: Both the zeroes are moved to the end and the order of the other elements stay the same
Input: nums = [0, 0, 0, 1, 3, -2]
Output: [1, 3, -2, 0, 0, 0]
Explanation: All 3 zeroes are moved to the end and the order of the other elements stay the same
 */
public class Q07_ZeroesToEnd {
    public static void main(String[] args) {
        int[] arr = {0, 0, 0, 1, 3, -2};
        bruteForce(arr);
        int[] arr1 = {0, 1, 4, 0, 5, 2};
        optimal(arr1);
    }

    static void bruteForce(int[] arr) {
        int[] zero = new int[arr.length];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i]!=0) {
                zero[j]=arr[i];
                j++;
            }
        }
        System.out.println(Arrays.toString(zero));
    }
    static void optimal(int[] arr) {
        /*
        use 2 ptrs = left and right
        left for index-0, right for index-1
        if left=0 : swap their vals
            > if left is still 0 after swapping : incr right
            > if left is non-zero : incr both the ptrs by 1
        else : no swapping & incr both the ptrs by 1
         */
        int left=0, right=1;
        while (right < arr.length) {
            if (arr[left]==0) {
                int temp=arr[left];
                arr[left]=arr[right];
                arr[right]=temp;
            }
            if (arr[left]==0) {
                right++;
            } else {
                left++;
                right++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
