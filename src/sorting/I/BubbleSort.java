package sorting.I;

import java.util.Arrays;

/*
aka sinking sort OR exchange sort
- after every pass, array size for comparison gets smaller by 1
- no extra space used => space complexity = O(1) : in-place sorting
- 2 nested loops used => time complexity = O(n^2)
- if in any pass, no swapping takes place, this means array got or is already sorted. In this case we break the outer loop to stop further passes to take place. (Best Case - O(n) )
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] test1 = {3,1,5,4,2};
        int[] test2 = {1,2,3,4,5};
        bubble(test1);
        bubble(test2);
    }
    static void bubble(int[] nums) {
        int j = nums.length-1;
        int flag=0;
        while (j>0) {
            for (int i = 0; i < j; i++) { // loop represents one pass
                if (nums[i] > nums[i+1]) {
                    int temp = nums[i];
                    nums[i] = nums[i+1];
                    nums[i+1] = temp;
                    flag=1;
                }
            }
            if (flag == 1) {
                j--; // size decrements after a pass that has gone through swap :: if no swaps occurred > array=sorted > break loop
                flag=0;
            } else {
                break;
            }
        }

        /*
        for (int i = test1.length-1; i > 0; i--) { // pass
            for (int j = 0; j < test1.length-1; j++) { // comparison per pass
                if (test1[j] > test1[j+1]) {
                    int temp = test1[j];
                    test1[j] = test1[j+1];
                    test1[j+1] = temp;
                }
            }
        }
         */

        System.out.println(Arrays.toString(nums));
    }
}
