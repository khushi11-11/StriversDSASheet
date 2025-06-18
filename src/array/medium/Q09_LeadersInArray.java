package array.medium;
/*
LEADERS IN AN ARRAY~
Problem Statement: Given an array, print all the elements which are leaders. A Leader is an element that is greater than all the elements on its right side in the array.
Example 1:
Input:arr = [4, 7, 1, 0]
Output:7 1 0
Explanation:Rightmost element is always a leader. 7 and 1 are greater than the elements in their right side.

Example 2:
Input:arr = [10, 22, 12, 3, 0, 6]
Output:22 12 6
Explanation:6 is a leader. In addition to that, 12 is greater than all the elements in its right side (3, 0, 6), also 22 is greater than 12, 3, 0, 6.
 */
public class Q09_LeadersInArray {
    public static void main(String[] args) {
        int[] arr1 = {4, 7, 1, 0};
        int[] arr2 = {10, 22, 12, 3, 0, 6};
        better(arr2);
    }
    static void solution(int[] nums) {
        int left=0, right=1;
        while (left != nums.length-1) {
            if (nums[right] > nums[left]) {
                left++;
                right=left+1;
            } else if (right == nums.length-1) {
                System.out.print(nums[left] + " ");
                left++;
                right=left+1;
            } else {
                right++;
            }
        }
        System.out.println(nums[nums.length-1]);
    }
    static void better(int[] nums) {
        int ptr= nums.length-1;
        int max = Integer.MIN_VALUE;
        while (ptr >= 0) {
            if (nums[ptr] > max) {
                max = nums[ptr];
                System.out.print(max + " ");
            }
            ptr--;
        }
    }
}
