package array.medium;

import java.util.Arrays;

/*
FIND THE MAJORITY ELEMENT THAT OCCURS MORE THAN N/2 TIMES~
Problem Statement: Given an array of N integers, write a program to return an element that occurs more than N/2 times in the given array. You may consider that such an element always exists in the array.
Example 1:
Input Format: N = 3, nums[] = {3,2,3}
Result: 3
Explanation: When we just count the occurrences of each number and compare with half of the size of the array, you will get 3 for the above solution.
Example 2:
Input Format:  N = 7, nums[] = {2,2,1,1,1,2,2}
Result: 2
Explanation: After counting the number of times each element appears and comparing it with half of array size, we get 2 as result.
Example 3:
Input Format:  N = 10, nums[] = {4,4,2,4,3,4,4,3,2,4}
Result: 4
 */
public class Q05_MajorityElement {
    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        int[] arr2 = {2,2,1,1,1,2,2};
        int[] arr3 = {4,4,2,4,3,4,4,3,2,4};
//        bruteForce(arr3, arr3.length/2);
//        betterApproach(arr1, arr1.length/2);
        System.out.println(moore_sVotingAlgo(arr3, arr3.length/2));
    }

    static void bruteForce(int[] arr, int min) {
        System.out.println("Time= O(n^2)? it uses the pointer curr to reset again making the array be traversed over n times for n elements");
        int left=0, curr=left, count=0;
        // left stays, curr matches with left, count counts occurence
        while (left < arr.length) {
            if (arr[curr] == arr[left]) {
                count++;
                curr++;
                if (count>min) {
                    System.out.println(arr[left]);
                    break;
                }
            } else if (arr[curr] != arr[arr.length-1]) {
                curr++;
            } else {
                left++;
                curr=left;
            }
        }
    }
    static <min> void betterApproach(int[] arr, int min) {
        Arrays.sort(arr);  // O(n log n)
        System.out.println("Time= O(n log n)? O(n log n) (for sorting) + O(n) (for counting)");
        int left = 0, curr = left, count = 0;
        while (left < arr.length) {
            if (arr[curr] == arr[left]) {
                count++;
                curr++;
                if (count > min) {
                    System.out.println(arr[left]);  // Found majority
                    break;
                }
            } else {
                left = curr; // shift left to the start of new number
                count = 0;
            }
        }
    }
    static int moore_sVotingAlgo(int[] arr, int min) {
        // imagine har element ko destroy krne k liye n/2 weapons h
        // this means -> agar n/2 weapons use krne pe bhi koi element ki aur replica(occurence) bachti h to vo majority h
        // instead of using weapons, hum elements ko ek dusre se cancel hone keh skte h
        // since, majority = more than half : therefore, it will still remain in the end

        int count=0, candidate=-1;
        for (int i : arr) {
            if (count==0) {
                candidate=i;
                // candidate assigned, whenever earlier candidate's occurrences get cancels out with other elements
            }
            if (i==candidate) count++;
                // if occurrence found
            else count--;
                // if other element found, it will cancel out 1 occurrence of the candidate
        }

        // Optional: verify if candidate is actually majority
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        if (count > arr.length / 2) return candidate;
        return -1;
    }
}
