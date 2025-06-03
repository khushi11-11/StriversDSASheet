package array.easy;

import java.util.Arrays;

/*
LEFT ROTATE ARRAY BY ONE~
Problem Statement: Given an integer array nums, rotate the array to the left by one.
Note: There is no need to return anything, just modify the given array.

Examples:
Input: nums = [1, 2, 3, 4, 5]
Output: [2, 3, 4, 5, 1]
Explanation: Initially, nums = [1, 2, 3, 4, 5]
Rotating once to left -> nums = [2, 3, 4, 5, 1]

Input: nums = [-1, 0, 3, 6]
Output: [0, 3, 6, -1]
Explanation: Initially, nums = [-1, 0, 3, 6]
Rotating once to left -> nums = [0, 3, 6, -1]
 */
public class Q05_LeftRotation {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        rotate(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    static int[] rotate(int[] arr1) {
        int temp = arr1[0];
//        keeping the 1st element value safely stored in temp
//        -why?- to update OR SWAP the last element with the old value of 1st element
        for (int i = 0; i < arr1.length-1; i++) {
            arr1[i] = arr1[i+1];
        }
        arr1[arr1.length-1] = temp;
        // these above 4 steps for left rotation by 1

        return (arr1);
    }
}



















