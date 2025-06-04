package array.easy;
/*
LINEAR SEARCH~
Problem Statement: Given an array of integers nums and an integer target, find the smallest index (0 based indexing) where the target appears in the array. If the target is not found in the array, return -1
Examples:
Input: nums = [2, 3, 4, 5, 3], target = 3
Output: 1
Explanation: The first occurrence of 3 in nums is at index 1
 */
public class Q08_LinearSearch {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 3};
        int target = 3;
        System.out.println(linear(arr, target));
    }

    static int linear(int[] arr, int target) {
        int idx=0;
        for( int x : arr) {
            if (x != target)
                idx++;
            else {
                return idx;
            }
        }
        return -1;
    }
}
