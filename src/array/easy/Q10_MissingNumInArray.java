package array.easy;
/*
FIND THE MISSING NUMBER IN AN ARRAY~
Problem Statement: Given an integer N and an array of size N-1 containing N-1 numbers between 1 to N. Find the number(between 1 to N), that is not present in the given array.
Input: nums = [0, 2, 3, 1, 4]
Output: 5
Explanation: nums contains 0, 1, 2, 3, 4 thus leaving 5 as the only missing number in the range [0, 5]
 */
public class Q10_MissingNumInArray {
    public static void main(String[] args) {
        int[] arr1 = {0, 2, 3, 1, 4};
        int n = arr1.length;
        int ans = find(arr1, n);
        System.out.println(ans);
    }

//    count occurrence of number from 1 to N
//    only one number is missing
    static int find(int[] a, int n) {
        while (n!=0) {
            int count=0;
            for (int i = 0; i < n; i++) {
                if (n==a[i]) count++;
            }
            if (count==0) return n;
        }
        return -1;
    }
}
