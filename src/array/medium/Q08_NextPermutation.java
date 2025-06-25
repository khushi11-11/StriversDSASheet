package array.medium;

import java.util.Arrays;

/*
NEXT PERMUTATION : FIND NEXT LEXICOGRAPHICALLY GREATER PERMUTATION~
Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.
If such an arrangement is not possible, it must rearrange to the lowest possible order (i.e., sorted in ascending order).
Example 1 :
Input format: Arr[] = {1,3,2}
Output: Arr[] = {2,1,3}
Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,1,3} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
Example 2:
Input format: Arr[] = {3,2,1}
Output: Arr[] = {1,2,3}
Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.
 */
public class Q08_NextPermutation {
    public static void main(String[] args) {
        int[] arr1 = {1,3,2};
        int[] arr2 = {3,2,1};
        int[] arr3 = {1,3,5,4,2};
        int[] arr4 = {5,4,3,2,1};
        bruteForce(arr3);
    }

    static void bruteForce(int[] nums) {
        int i = nums.length-2; // start from second last element
        while (i>=0 && nums[i]>=nums[i+1])
            i--; // finding i, the breakpoint
        // swapping logic, find number which is smaller to its right one -> then swap it with the smallest number of those that are greater than it
        if (i!=-1) {
            // Among the numbers greater than i, we want the smallest of them
            int j = nums.length-1;
            while (nums[j] <= nums[i]) j--;
            // swapping
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        // reversing, basically swapping with 2 pointer approach
        // out of the loop, bcz it has to be done even if there is no possible next permutation left
        int left=i+1, right= nums.length-1;
        while (left<=right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(nums));
    }
}
