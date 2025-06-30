package array.hard;
/*
MAXIMUM PRODUCT SUBARRAY IN AN ARRAY~
extended kadane's
Problem Statement: Given an array that contains both negative and positive integers, find the maximum product subarray.
Example 1:
Input:Nums = [1,2,3,4,5,0]
Output:120
Explanation:In the given array, we can see 1×2×3×4×5 gives maximum product value.
Example 2:
Input:Nums = [1,2,-3,0,-4,-5]
Output:20
Explanation:In the given array, we can see (-4)×(-5) gives maximum product value.
 */
public class Q12_MaxProductSubarray {
    public static void main(String[] args) {
        int[] test1 = {1,2,3,4,5,0}; // Expected: 120 (basic positive nums)
        int[] test2 = {1,2,-3,0,-4,-5};

        int[] arr2 = {-1, -2, -3, -4}; // Expected: 24 (all negatives) - even count
        int[] arr3 = {-1, -2, -3}; // Expected: 6  (exclude the largest negative if needed) - odd count
        int[] arr4 = {2, 3, -2, 4}; // Expected: 6  (2 × 3) (mix of positives and negatives)
        int[] arr5 = {-2, 0, -1}; // Expected: 0 (can't cross over the 0)
        int[] arr6 = {0, -2, 0, -3, 4}; // Expected: 4
        int[] arr7 = {7}; // Expected: 7
        int[] arr10 = {-1, -3, -10, 0, 60}; // Expected: 60 (Longest Product Not at Start or End)
        int[] arr11 = {-2, -3, 0, -2, -40}; // Expected: 80

        solution(test1);
        solution(test2);
        solution(arr2);
        solution(arr3);
        solution(arr4);
        solution(arr5);
        solution(arr6);
        solution(arr7);
        solution(arr10);
        solution(arr11);
    }
    static void solution(int[] nums) {
        int curr_max=nums[0];
        int max_so_far=nums[0];
        int curr_min=nums[0]; // to handle neg*neg

        for (int num : nums) {
            int temp = curr_max;

            curr_max = Math.max(num, Math.max(curr_max*num, curr_min*num));
            curr_min = Math.min(num, Math.min(temp*num, curr_min*num));

            max_so_far = Math.max(max_so_far, curr_max);
        }
        System.out.println(max_so_far);
    }
}
