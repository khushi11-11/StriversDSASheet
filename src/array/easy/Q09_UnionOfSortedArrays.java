package array.easy;

import java.util.ArrayList;
import java.util.HashSet;

/*
UNION OF TWO SORTED ARRAYS~
Problem Statement: Given two sorted arrays, arr1, and arr2 of size n and m. Find the union of two sorted arrays.
The union of two arrays can be defined as the common and distinct elements in the two arrays, and are present in either the first array, the second array, or both.
NOTE: Elements in the union should be in ascending order.

Example:
Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
Output: [1, 2, 3, 4, 5, 7]
Explanation: The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
 */
public class Q09_UnionOfSortedArrays {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {1, 2, 7};

        System.out.println(union(arr1, arr2));
    }

    // ek hash set bna lo -> usme array1 ki values put krdo -> phir arr2 ki seq me
    static HashSet<Integer> union(int[] a1, int[] a2) {
        ArrayList<Integer> arr = new ArrayList<>();
        // bcoz size is not required in declaration
        for (int i : a1) {
            arr.add(i);
        }
        for (int i : a2) {
            arr.add(i);
        }
        HashSet<Integer> union = new HashSet<>(arr);
        // removes duplicates
        // can use instead a for loop or simply union.addAll(arr);
        return union;
    }
}
