package array.daily;

import java.util.Arrays;

public class MajorityElementNby2 {
    public static void main(String[] args) {
        int[] test1 = {2,1,2};
        int[] test2 = {2,2,1,1,1,2,2};
        int[] test3 = {4,4,2,4,3,4,4,3,2,4};
        solution(test1);
        boyerMooreVoting(test2);
        boyerMooreVoting(test3);
    }
    static void solution(int[] nums) {
        Arrays.sort(nums);
        int count=1, curr=nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (curr==nums[i]) {
                count++;
            } else {
                count--;
            }
            if (count==0) {
                curr = nums[i+1];
            }
        }
        System.out.println(curr);
    }
    static void boyerMooreVoting(int[] nums) { // doesn't use extra space - no sorting
        int count=0, candidate=0;
        for (int i : nums) {
            if (count==0) {
                candidate=i;
            }
            if (i==candidate) {
                count++;
            } else {
                count--;
            }
        }
        System.out.println(candidate);
    }
}
