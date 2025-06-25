package recursion;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr1 = {1, 5, 12, 27, 31, 46, 83, 91};
        int target = 83;
        int idx = search(arr1, target, 0, arr1.length-1);
        System.out.println(idx);
    }

    static int search(int[] nums, int target, int s, int e) {
    // nums, target passed as usual. s,e passed (as args) bcoz they are needed for every next fxn call
        if (s>e) return -1; // binary search logic
        int m = s+(e-s)/2; // m (body of fxn) calculated here bcoz it will change for every fxn respective of s & e of the call
        if (nums[m] == target) return m;
        if (nums[m] > target) return search(nums, target, s, m-1);
        return search(nums, target, m+1, e);
    }
}
