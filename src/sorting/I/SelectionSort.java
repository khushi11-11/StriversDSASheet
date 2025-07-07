package sorting.I;

import java.util.Arrays;

/*
- select the largest element
- put it at the end, by swapping
- shrink array size by 1 for searching
- or vice versa
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] test1 = {4,5,1,2,3};
        selection(test1);
    }

    static void selection(int[] nums) {
        /*
        // method-2
        int j=0;
        while (j < nums.length-1) {
            int idx = j;
            for (int i = j+1; i < nums.length; i++) {
                if (nums[i] < nums[idx]) { // find min val, asc order
                    idx = i;
                }
            }
            int temp = nums[j];
            nums[j] = nums[idx];
            nums[idx] = temp;
            j++;
        }
         */



//        we need to find the index of smallest element to swap it with outer-loop index element
        for (int i = 0; i < nums.length-1; i++) {
            int idx=i; // set idx
            for (int k = i+1; k < nums.length; k++) {
                if (nums[k] < nums[idx]) idx=k; // update idx by comparing for min val
            }
            // found index of min value -> now swap
            int temp = nums[i];
            nums[i] = nums[idx];
            nums[idx] = temp;
        }
        System.out.println(Arrays.toString(nums));
    }
}
