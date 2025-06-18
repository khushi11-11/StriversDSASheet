package array.daily;

import java.util.ArrayList;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int target = 15;
        solution(arr1, target);
    }
    static void solution(int[] nums, int k) {
        int left=0, right=0, sum=0, len=0;
        int start=0, end=0;
        while (right < nums.length) {
            sum += nums[right];
            if (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
                len = Math.max(len, right-left+1);// +1 bcz initially (when loop starts) left and right is the same but still adds up to sum
                start = left;
                end = right;

            }
            right++;
        }
        System.out.println(len);
        if (start==end)
            System.out.println("No subarray found with sum " + k);
        else {
            for (int i=start; i <= end; i++)
                System.out.print(nums[i] + " ");
        }
    }
}
