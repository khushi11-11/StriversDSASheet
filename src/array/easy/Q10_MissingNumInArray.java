package array.easy;

import java.util.Arrays;

/*
FIND THE MISSING NUMBER IN AN ARRAY~
Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
Input: nums = [0, 2, 3, 1, 4]
Output: 5
Explanation: nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]
 */
public class Q10_MissingNumInArray {
    public static void main(String[] args) {
        int[] arr1 = {0, 2, 1, 4};
        int[] arr2  = {2,4,5,1};
        int n = arr1.length;
        int m= arr2.length;
        int ans = find(arr1, n);
        System.out.println(ans);
        System.out.println(find(arr2, m));
//        optimalMath(arr1);
//        optimalMath(arr2);
    }

//    count occurrence of number from 1 to N
//    only one number is missing
    static int find(int[] a, int n) {
        Arrays.sort(a);
        if (a[0]==0) {
        //  index starts from 0
            for (int i = 1; i < n; i++) {
                if (a[i] != i) return i;
            }
        } else {
        //  if first element is not 0 => a[0] must be 1, i.e., i+1 (i=0)
            for (int i = 0; i < n; i++) {
                if (a[i] != i+1) return i+1;
            }
        }

        return -1;
    }

//    static void optimalMath(int[] a) {
////        follows the total sum method, subtracts actual sum from desired sum
////        works great when 0 is in the array
//        int n = a.length;
//        int total = n*(n+1)/2;
//        int sum=0;
//        for (int i = 0; i < n-1; i++) sum += i;
//        System.out.println(total-sum);
//    }
}
