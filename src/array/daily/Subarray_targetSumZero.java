package array.daily;

import java.util.HashMap;

public class Subarray_targetSumZero {
    public static void main(String[] args) {
        int[] arr = {4, 2, -3, 1, 6}; // 4, 6, 3, 4, 10
        // target = 0
        Boolean exist = solution(arr);
        System.out.println(exist);
    }

    static Boolean solution(int[] nums) {
        int prefix=0;
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];

            if (map.containsKey(prefix)) { // prefix-0 = prefix
                return true;
            } else {
                map.put(prefix, i);
            }
        }
        return false;
    }
}
