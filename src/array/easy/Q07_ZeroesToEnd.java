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
        moveZroes(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void moveZroes(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            if (arr[i]==0){ // when a 0 is encountered in the array
                while (arr[i]!=0) { // for continuous 0s in array
                    for (int j = i; j < arr.length - 1; j++)
                        arr[j] = arr[j + 1]; // left rotating the array in loop
                    arr[arr.length - 1] = 0; // updating last value with 0 -why?- moving the 0 to end
                }
            }
        }
    }
}
