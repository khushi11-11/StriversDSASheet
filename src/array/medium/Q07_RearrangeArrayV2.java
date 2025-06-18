package array.medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
REARRANGE ARRAY ELEMENTS BY SIGN (Variety-2)~
Problem Statement: There’s an array ‘A’ of size ‘N’ with positive and negative elements *(not necessarily equal)*. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values. The leftover elements should be placed at the very end in the same order as in array A.
Note: Start the array with positive elements.
Example 1:
Input:
arr[] = {1,2,-4,-5,3,4}, N = 6
Output:
1 -4 2 -5 3 4
Explanation:
Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.
Leftover positive elements are 3 and 4 which are then placed at the end of the array.
 */
public class Q07_RearrangeArrayV2 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,-4,-5,3,4};
        solution(arr1);
    }
    static void solution(int[] nums) {
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i : nums) {
            if (i<0) neg.add(i);
            else pos.add(i);
        }
        int i=0, p=0, n=0;
        while (p < pos.size() && n < neg.size()) {
            nums[i++] = pos.get(p++);
            nums[i++] = neg.get(n++);
            // first get the value at index (i,p,n) then incr it by 1 for next itr
        }

        // if extra values found, i has not been reset to 0
        while (p < pos.size()) nums[i++] = pos.get(p++);
        while (n < neg.size()) nums[i++] = neg.get(n++);

        // return the rearranged array
        System.out.println(Arrays.toString(nums));
    }
}
