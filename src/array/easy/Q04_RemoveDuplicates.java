package array.easy;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

/*
REMOVE DUPLICATES IN-PLACE FROM SORTED ARRAY~
Problem Statement: Given an integer array sorted in non-decreasing (ascending) order, remove the duplicates in place such that each unique element appears only once. The relative order of the elements should be kept the same.
If there are k elements after removing the duplicates, then the first k elements of the array should hold the final result. It does not matter what you leave beyond the first k elements.
Note: Return k after placing the final result in the first k slots of the array.

Example 1:
Input: arr[1,1,2,2,2,3,3]
Output: arr[1,2,3,_,_,_,_]
Explanation: Total number of unique elements are 3, i.e[1,2,3] and Therefore return 3 after assigning [1,2,3] in the beginning of the array.
 */
public class Q04_RemoveDuplicates {
    public static void main(String[] args) {
        int[] arr1 = {1,1,2,2,2,3,3};
        int[] arr2 = {1,1,2};
        int[] arr3 = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(arr1));
//        brute(arr1);

//        System.out.println(nonDuplicates(arr3));
    }

    static String removeDuplicates(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1; j++) {
//          comparing to all the array elements
                if (arr[j] == arr[i]) {
//              when any array element is found to be equal to the current array val => duplicate
                    arr[j]=0;
                }
                if (arr[j] == 0) {
//              swapping the current (or prvsly) set 0 value with the next element
                    arr[j] = arr[j+1];
                    arr[j+1] = 0;
                }
            }
        }
        return Arrays.toString(arr);
    }

//    static int nonDuplicates(int[] nums) {
//        int s=0;
////        s is like a "slow pointer" — it tracks where the next unique number should go.
////        i is a "fast pointer" — it scans through the array to check for new unique numbers.
//        for (int i=1; i<nums.length; i++) {
//            if (nums[i]!=nums[s]) {
//                s++;
//                nums[s]=nums[i];
//                nums[i]=0;
//            }
//        }
//        return s+1;
//    }
     static void brute(int[] arr) {
         // Pseudo
         Set<Integer> set = new LinkedHashSet<>();
         for(int num : arr) set.add(num);
         int i = 0;
         for(int num : set) arr[i++] = num;
         System.out.println(Arrays.toString(arr));
     }
}







/*
TIP :- HashSet is a data str. that stores all unique values, and no duplicates.
 */



