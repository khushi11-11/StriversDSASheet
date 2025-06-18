package array.medium;

import java.util.ArrayList;
import java.util.Arrays;

/*
REARRANGE ARRAY ELEMENTS BY SIGN~
Problem Statement:There’s an array ‘A’ of size ‘N’ with an equal number of positive and negative elements. Without altering the relative order of positive and negative elements, you must return an array of alternately positive and negative values.
Note: Start the array with positive elements.

Example 1:
Input:
arr[] = {1,2,-4,-5}, N = 4
Output:
1 -4 2 -5
Explanation:
Positive elements = 1,2
Negative elements = -4,-5
To maintain relative ordering, 1 must occur before 2, and -4 must occur before -5.

Example 2:
Input:
arr[] = {1,2,-3,-1,-2,-3}, N = 6
Output:
1 -3 2 -1 3 -2
Explanation:
Positive elements = 1,2,3
Negative elements = -3,-1,-2
To maintain relative ordering, 1 must occur before 2, and 2 must occur before 3.
Also, -3 should come before -1, and -1 should come before -2.
 */
public class Q07_RearrangeArrayV1 {
    public static void main(String[] args) {
        int[] arr1 = {1,2,-4,-5};
        int[] arr2 = {1,2,-3,-1,-2,3};
        better(arr1);
        bruteForce(arr2);
    }

    static void bruteForce(int[] arr) {
        // does not maintain original order
        Arrays.sort(arr);
        int left = 0, curr = arr.length / 2;
        while (curr < arr.length) {
            if (arr[curr] < 0) {
                curr++;
            } else {
                int temp = arr[left];
                arr[left] = arr[curr];
                arr[curr] = temp;

                left += 2;
                curr++;
            }
        }
        System.out.println(Arrays.toString(arr));

        /*
        Requires sorted input
        Breaks on uneven count (Uneven Pos/Neg Count) What if one of the signs is more than the other?
        Destroys order (if that matters) It changes the original order of elements — in some interview versions of this problem, order must be preserved.
         */
    }

    static void better(int[] nums) {
        // takes more space
        ArrayList<Integer> pos = new ArrayList<>();
        ArrayList<Integer> neg = new ArrayList<>();
        for (int i : nums) {
            if (i<0) neg.add(i);
            else pos.add(i);
        }
        int j=0, k=0;
        for (int i = 0; i < nums.length; i++) {
            if (i%2 == 0) {
                nums[i] = pos.get(j);
                j++;
            } else {
                nums[i] = neg.get(k);
                k++;
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    /*
    Rearrange the array to alternate positive & negative numbers
    Without using extra space (no ArrayLists)
    Preserve relative order — still required
    No sorting!
    => You can’t do both — maintain relative order and do it in-place — without O(N²) time.
     */
    static void optimal(int[] nums) {
        int[] res = new int[nums.length];  // new result array
        int pos = 0;  // pointer for even indices
        int neg = 1;  // pointer for odd indices

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= 0) {
                res[pos] = nums[i];  // place positive number at even index
                pos += 2;            // move to next even index
            } else {
                res[neg] = nums[i];  // place negative number at odd index
                neg += 2;            // move to next odd index
            }
        }
// array nums se sequentially vals utha k res naam ki array me alternately put krre h by sign
        System.out.println(Arrays.toString(res));;
    }
}





















