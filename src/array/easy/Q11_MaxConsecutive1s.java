package array.easy;


/*
COUNT MAXIMUM CONSECUTIVE ONE'S IN THE ARRAY~
Problem Statement: Given an array that contains only 1 and 0 return the count of maximum consecutive ones in the array.
Example 1:
Input: prices = {1, 1, 0, 1, 1, 1}
Output: 3
Explanation: There are two consecutive 1’s and three consecutive 1’s in the array out of which maximum is 3.
Input: prices = {1, 0, 1, 1, 0, 1}
Output: 2
Explanation: There are two consecutive 1's in the array.
 */
public class Q11_MaxConsecutive1s {
    public static void main(String[] args) {
        int[] arr1 = {1, 1, 0, 1, 1, 1};
        int ans = result(arr1);
        System.out.println(ans);
    }

    static int result(int[] arr1) {
//        ArrayList<Integer> counter = new ArrayList<>();
        int count=0, max = Integer.MIN_VALUE;
        for (int i : arr1) {
            if(arr1[i]==1 /*&& i!=arr1.length-1*/) {
                count++;
//            } else if (arr1[i]==1 && i==arr1.length-1) {
//                count++;
//                counter.add(count);
            } else {
//                counter.add(count);
                count=0;
            }
            if (max<count) max=count;
        }
        return max;
    }
}
