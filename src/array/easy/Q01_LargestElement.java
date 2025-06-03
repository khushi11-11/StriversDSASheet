package array.easy;
/*
LARGEST ELEMENT IN AN ARRAY
Given an array of integers nums, return the value of the largest element in the array
Examples:
Input: nums = [3, 3, 6, 1]
Output: 6
Explanation: The largest element in array is 6
 */
public class Q01_LargestElement {
    public static void main(String[] args) {
        int[] array = {3,3,6,1};
        int ans = largest(array);
        System.out.println(ans);
    }

    static int largest(int[] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if ( max<arr[i] )
                max = arr[i];
        }
        return max;
    }
}
