package array.medium;

import java.util.Arrays;
import java.util.HashMap;

/*
Two Sum : Check if a pair with given sum exists in Array
Problem Statement: Given an array of integers arr[] and an integer target.
1st variant: Return YES if there exist two numbers such that their sum is equal to the target. Otherwise, return NO.
2nd variant: Return indices of the two numbers such that their sum is equal to the target. Otherwise, we will return {-1, -1}.

Note: You are not allowed to use the same element twice. Example: If the target is equal to 6 and num[1] = 3, then nums[1] + nums[1] = target is not a solution.

Example 1:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 14
Result: YES (for 1st variant)
       [1, 3] (for 2nd variant)
Explanation: arr[1] + arr[3] = 14. So, the answer is “YES” for the first variant and [1, 3] for 2nd variant.
Example 2:
Input Format: N = 5, arr[] = {2,6,5,8,11}, target = 15
Result: NO (for 1st variant)
	[-1, -1] (for 2nd variant)
Explanation: There exist no such two numbers whose sum is equal to the target.
 */
public class Q01_2sumProblem {
    public static void main(String[] args) {
        int[] arr = {2,6,5,8,11};
        int target1 = 14;
        int target2 = 15;
//        System.out.println(bruteForce(arr, target2));
        optimal(arr, target1);
    }

    static String bruteForce(int[] arr, int k) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[i]+arr[j] == k) {
                    return "Yes, at index : " + i + "," + j;
                }
            }
        }
        return "No";
    }
    static void optimal(int[] arr, int k) { // uses hashmap
//        While traversing the array, we check if (target - current element) exists in the map
//        If it does, we found the pair! : Otherwise, we store the current element in the map.
        HashMap<Integer,Integer> num = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int complement = k-arr[i];
            if (num.containsKey(complement)) {
                System.out.println("Found= " + complement + ", " + arr[i]);
                return;
            }
            num.put(arr[i], i);
        }
        System.out.println("No such pair found");
    }
}
