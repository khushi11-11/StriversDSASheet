package array.hard;

import java.lang.reflect.Array;
import java.util.Arrays;

/*
MERGE TWO SORTED ARRAYS WITHOUT EXTRA SPACE ~
Problem statement: Given two sorted arrays arr1[] and arr2[] of sizes n and m in non-decreasing order. Merge them in sorted order. Modify arr1 so that it contains the first N elements and modify arr2 so that it contains the last M elements.

Example 1:
Input:
n = 4, arr1[] = [1 4 8 10]
m = 5, arr2[] = [2 3 9]
Output:
arr1[] = [1 2 3 4]
arr2[] = [8 9 10]
Explanation:
After merging the two non-decreasing arrays, we get, 1,2,3,4,8,9,10.

Example2:
Input:
n = 4, arr1[] = [1 3 5 7]
m = 5, arr2[] = [0 2 6 8 9]
Output:
arr1[] = [0 1 2 3]
arr2[] = [5 6 7 8 9]
Explanation:
After merging the two non-decreasing arrays, we get, 0 1 2 3 5 6 7 8 9.
 */
public class Q08_MergeSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 4, 8, 10};
        int[] arr2 = {2, 3, 9};
        solution(arr1, arr2);
    }
    static void solution(int[] nums1, int[] nums2) {
        // fill nums1
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > nums2[0]) {
                // Swap nums1[i] with the first element of nums2
                int temp = nums1[i];
                nums1[i] = nums2[0];
                nums2[0] = temp;

                // Place nums2[0] (now unsorted) into correct position in nums2
                int first = nums2[0];
                int j;
                for (j = 1; j < nums2.length && nums2[j] < first; j++) {
                    nums2[j - 1] = nums2[j]; // shift smaller elements left
                    // val of 0 idx is already stored in vble first, so we can reliably set idx 1 vl to idx 0 to initiate the shifting
                }
                nums2[j - 1] = first; // insert the swapped element in right place
            }
        }
        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));
    }

//    // without using extra space — also known as the Gap Method (inspired by Shell Sort), smart pointer jumps.
//    static void optimal(int[] nums1, int[] nums2) {
//        // gap method
//        // Treat both arrays as one virtual array of size n + m.
//        int n = nums1.length, m = nums2.length;
//
//        /*
//         gap equal to half of the total elements (rounded up)
//         Shell Sort: controls how far apart (if gap=4, one element will be 0,1,2,3 other will be 4,5,6,7) the two comparing elements are
//	     Why ceil? Because if n+m is odd, gap needs to be rounded up
//         */
//        int gap = (int) Math.ceil((n + m) / 2.0); // 0 1 2 3 '4' 5 6 7
//
//
//        while (gap > 0) { // Each pass brings larger elements toward the right and vice versa
//            int left=0, right=gap; // comparison pointers
//
//            while (right < (n+m)) {
//                int val1 = getValue(nums1, nums2, left, n);
//                int val2 = getValue(nums1, nums2, right, n);
//                if (val1 > val2) {
//
//                }
//            }
//
//        }
//    }
//
//    static int getValue(int[] nums1, int[] nums2, int right, int n) {
//    }
}
