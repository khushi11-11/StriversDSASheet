package array.daily;

public class SubarrayWithSumK {
    public static void main(String[] args) {
        int[] arr1 = {10, 5, 2, 7, 1, 9};
        int[] arr2 = {9, 1, 7, 2, 5, 10};
        int target = 15;
        solution(arr1, target);
        solution(arr2, target);
    }
    static void solution(int[] nums, int k) {
        int left=0, right=0; // for window
        int sum=0, len=0; // for tracking sum and max length of subarray
        int start=0, end=0; // for tracking index of subarray to print it
        while (right < nums.length) {
            sum += nums[right];
            if (sum > k) {
                sum -= nums[left];
                left++;
            }
            if (sum == k) {
//                len = Math.max(len, right-left+1);// +1 bcz initially (when loop starts) left and right is the same but still adds up to sum
                if (len < right-left+1) {
                    start = left;
                    end = right;
                    len = right-left+1;
                }
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
