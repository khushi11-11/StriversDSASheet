package array.hard;

import java.util.Arrays;
import java.util.HashMap;

/*
FIND THE REPEATING AND MISSING NUMBERS~
Problem Statement: You are given a read-only array of N integers with values also in the range [1, N] both inclusive. Each integer appears exactly once except A which appears twice and B which is missing. The task is to find the repeating and missing numbers A and B where A repeats twice and B is missing.
Example 1:
Input Format:  array[] = {3,1,2,5,3}
Result: {3,4)
Explanation: A = 3 , B = 4
Since 3 is appearing twice and 4 is missing
Example 2:
Input Format: array[] = {3,1,2,5,4,6,7,5}
Result: {5,8)
Explanation: A = 5 , B = 8
Since 5 is appearing twice and 8 is missing

 */
public class Q09_FindMissingAndRepeating {
    public static void main(String[] args) {
        int[] arr1 = {3,1,2,5,3};
        int[] arr2 = {3,1,2,5,4,6,7,5};

        solution(arr1, arr1.length);
        solution(arr2, arr2.length);

        spaceOptimal(arr1, arr1.length);
        spaceOptimal(arr2, arr2.length);
    }
    static void solution(int[] nums, int n) {
        int[] ans = new int[2]; // A: repeats twice, B: missing one
        HashMap<Integer,Integer> map = new HashMap<>();

        // Step 1: Create a frequency map from 1 to N initialized to 0
        int i;
        for (i = 1; i <= n; i++) {
            map.put(i, 0); // initialise hashmap with vals from 1 to N with freq not yet calculated to 0
        }
        // Step 2: Count frequencies while checking for the repeating number
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.get(num) == 2) ans[0] = num;
        }
        // Step 3: Find the number that never appeared
        i=1;
        while (i <= n) {
            if (map.get(i) == 0) {
                ans[1] = i;
                break;
            }
            i++;
        }
        System.out.println(Arrays.toString(ans));
    }

    static void spaceOptimal(int[] nums, int n) {
        // x=repeating, y=missing

        // 1. Calculate expected sums:
        long sum_n = (long) n * (n + 1) / 2;
        long sq_sum_n = (long) n * (n + 1) * (2L *n + 1) / 6; // replaced 2 with 2L, implicit casting, to avoid integer overflow with large n

        // 2. Calculate actual sums from array:
        long sum=0, sq_sum=0;
        for (int i : nums) {
            sum += (long) i;
            sq_sum += (long) i*i;
        }

        // S - Sn = x - y => (Equation 1)
        // S2 - S2n = x² - y² = (x - y)(x + y)=> (Equation 2)
        long eq1 = sum-sum_n; // gives (calculates) x-y
        long eq2 = sq_sum-sq_sum_n; // x² - y²

        // since eq2: x² - y² = (x - y)(x + y), divide val of eq1 into eq2
        // (x - y)(x + y) / (x - y) = x+y => sum of x and y
        long sum_xy = eq2/eq1;

        // we have: (x+y) & (x-y)
        // adding them = 2x, and then dividing it will give x
        long x = (sum_xy + eq1)/2;
        // we have: x-y & x
        // subtracting x from it = -y, then adding a minus(-) sign again will give y
        long y = -(eq1 - x);

        long[] ans = {x, y};
        System.out.println(Arrays.toString(ans));
    }
}


















