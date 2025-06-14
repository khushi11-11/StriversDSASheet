package array.medium;

import java.util.Arrays;

/*
SORT AN ARRAY OF 0s, 1s and 2s ~
(Dutch National Flag Problem)
Problem Statement: Given an array consisting of only 0s, 1s, and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)
Examples
Input1: nums = [2,0,2,1,1,0]
Output1: [0,0,1,1,2,2]
Input2: nums = [2,0,1]
Output2: [0,1,2]
Input3: nums = [0]
Output3: [0]
 */
public class Q02_SortArray {
    public static void main(String[] args) {
        int[] arr1 = {2,0,2,1,1,0};
//        bruteForce(arr1);
        int[] arr2 = {2,0,1};
        optimal(arr1);
    }

    static void bruteForce(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[i]) {
                    arr[i] = arr[i]^arr[j];
                    arr[j] = arr[i]^arr[j];
                    arr[i] = arr[i]^arr[j];
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    static void optimal(int[] arr) {
        /*
         The 3 Pointers:
            low → boundary for 0s
            mid → current element
            high → boundary for 2s
        >> Rules (repeat while mid <= high):
            If arr[mid] == 0:
              swap with arr[low], increment both low and mid
            If arr[mid] == 1:
 ️              just mid++
            If arr[mid] == 2:
                swap with arr[high], decrement high only
         */
        int low=0, mid=0, high= arr.length-1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                arr[low] = arr[low]^arr[mid];
                arr[mid] = arr[low]^arr[mid];
                arr[low] = arr[low]^arr[mid];
                low++;
                mid++;
            } else if (arr[mid] == 2) {
                arr[high] = arr[high]^arr[mid];
                arr[mid] = arr[high]^arr[mid];
                arr[high] = arr[high]^arr[mid];
                high--;
            } else {
                mid++;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
