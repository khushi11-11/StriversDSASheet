package array.easy;

import java.util.HashMap;
import java.util.Map;

/*
FIND THE NUMBER THAT APPEARS ONCE, AND THE OTHER NUMBERS TWICE~
Problem Statement: Given a non-empty array of integers arr, every element appears twice except for one. Find that single one.
Example 1:
Input Format: arr[] = {2,2,1}
Result: 1
Explanation: In this array, only the element 1 appear once and so it is the answer.
Example 2:
Input Format: arr[] = {4,1,2,1,2}
Result: 4
Explanation: In this array, only element 4 appear once and the other elements appear twice. So, 4 is the answer.
 */
public class Q12_SingleNumber {
    public static void main(String[] args) {
        int[] arr1 = {2,2,1};
        int[] arr2 = {4,1,2,1,2};
        int[] arr3 = {1, 2, 2, 4, 3, 1, 4};
        int ans = bruteForce(arr1);
        int ans2 = betterApproach(arr2);
        int ans3 = optimalApproach(arr3);
        System.out.println("Brute Force Approach= " + ans);
        System.out.println("Better Approach= " + ans2);
        System.out.println("Optimal Approach= " + ans3);
    }

    static int bruteForce(int[] arr) {
        for (int i : arr) {
            int count=0;
            for (int j : arr) {
                if (j==i) count++;
            }
            if (count==1) return i;
        }
        return -1;
    }

    static int betterApproach(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            int val = map.getOrDefault(i, 0);
            // if already exists (val=1), if not val=0
            map.put(i,val+1);
            // val=val+1 -why?- when array element exists in the map it will give the val 1 -> incremented by 1 = 2 : indicating duplicate occurrence
            // when the array element is not present in map the def val which is 0 is used -> incr by 1 = 1
        }
        // has map stores unique value that means when we itrate over the array, every value will be checked in the hash map that we have defined and then a value is found while trading over array that means if an element has already been recorded into map from Arey, the value will be 1+1 as it exists in Mac, which means the value is one and when we put it again in the map, the value will be updated by incrementing it by one and if the value from RA or the element from array does not already exist in the map, then the default value which is zero will be used to replace the value of that element in the hash map, which will be 0+ one is equal to 1

        for (Map.Entry<Integer, Integer> x : map.entrySet()) {
            if (x.getValue()==1) return x.getKey();
        }
        // just like int works for array of in type, Map.Entry works for HashMap
        return -1;
    }

    static int optimalApproach(int[] arr) {
        int xor=0;
        for (int i : arr) {
            xor = xor^i;
        }
        return xor;
    }
}

/*
brute force approach says use 2 loops
better approach says use hashmaps
optimal approach says use xor
 */