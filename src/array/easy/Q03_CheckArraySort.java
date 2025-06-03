package array.easy;
/*
CHECK IF AN ARRAY IS SORTED~
Problem Statement: Given an array of size n, write a program to check if the given array is sorted in (ascending / Increasing / Non-decreasing) order or not. If the array is sorted then return True, Else return False.
Note: Two consecutive equal values are considered to be sorted.
 */
public class Q03_CheckArraySort {
    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {5,4,6,7,8};
        int[] arr3 = {1,2,3,3,2};
        int[] arr4 = {1,1,1,1,1};
        System.out.println(check(arr4));
    }

    static boolean check(int[] arr) {
        for (int i=0; i<arr.length-1; i++) {
//      for (int i=1; i<arr.length; i++) { if(arr[i] < arr[i - 1]) return false; } return true;

//      arr.length-1 => for i=4, if cond asks for arr[i+1] & arr[i]
//                      arr[i+1]=arr[5] gives IndexOutOfBound error

            if (arr[i+1] < arr[i]) return false;
//            jaha bhi ye cond true hogi to false return hoga aur loop, method, aur sb kuch break ho jayega
        }
        return true;
//        agar if cond true hoti hi ni h, to for loop break ni hoga return(17) stmt se, aur return(20) run hoga
    }
}
