package array.medium;

import java.util.ArrayList;

public class Q04_ExtendedKadanesAlgo {
    public static void main(String[] args) {
        int[] arr1 = {-2,1,-3,4,-1,2,1,-5,4};
        result(arr1);
    }

    static void result(int[] arr) {
        int curr_sum=arr[0];
        int max_so_far=arr[0];
        ArrayList<Integer> curr_arr = new ArrayList<>();
        int[] max;
        curr_arr.add(arr[0]);
        for (int i : arr) {
//            curr_sum = Math.max(curr_sum+i, i);
            if (curr_sum+i > i) {
                curr_sum = curr_sum+i; // keep adding
                curr_arr.add(i); // add to array
            } else {
                curr_arr.clear(); // restart the array
                curr_arr.add(i); // with new element
            }
//            max_so_far = Math.max(max_so_far, curr_sum);
            if (curr_sum < max_so_far) {
                max_so_far = curr_sum;
                curr_sum=0;
                curr_arr.clear();
            }
        }
        System.out.println(max_so_far);
        System.out.println(curr_arr);
    }
}
