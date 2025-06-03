package array.easy;
/*
2nd LARGEST ELEMENT~
- ceiling number*
Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.
Examples:
Input: nums = [8, 8, 7, 6, 5]
Output: 7
Explanation: The largest value in nums is 8, the second largest is 7
Input: nums = [10, 10, 10, 10, 10]
Output: -1
Explanation: The only value in nums is 10, so there is no second largest value, thus -1 is returned
 */
public class Q02_SecondLargestElement {
    public static void main(String[] args) {
        int[] arr1 = {8, 8, 7, 6, 5};
        int arr2[] = {10, 10, 10, 10, 10};

        int ans = result(arr1);
        System.out.println(ans);
    }

    static int result(int[] array) {
        int max=-1, max2=Integer.MIN_VALUE;
        for (int i : array) {
            if (i>max) {
                max2 = max;
                max = i;
            } else if (i>max2 && i!=max) {
                max2=i;
            }
        }
        return max2;
    }
}
