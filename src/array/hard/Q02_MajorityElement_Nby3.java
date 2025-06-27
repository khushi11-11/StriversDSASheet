package array.hard;
/*
MAJORITY ELEMENTS(N/3 TIMES) | Find the elements that appears more than N/3 times in the array
Problem Statement: Given an array of N integers. Find the elements that appear more than N/3 times in the array. If no such element exists, return an empty vector.
Pre-requisite: Majority Element(>N/2 times)
There can be at most 2 such elements
Example 1:
Input Format: N = 5, array[] = {1,2,2,3,2}
Result: 2
Explanation: Here we can see that the Count(1) = 1, Count(2) = 3 and Count(3) = 1.Therefore, the count of 2 is greater than N/3 times. Hence, 2 is the answer.
Example 2:
Input Format:  N = 6, array[] = {11,33,33,11,33,11}
Result: 11 33
Explanation: Here we can see that the Count(11) = 3 and Count(33) = 3. Therefore, the count of both 11 and 33 is greater than N/3 times. Hence, 11 and 33 is the answer.
 */
public class Q02_MajorityElement_Nby3 {
    public static void main(String[] args) {
        int[] test1 = {11,33,33,11,33,11};
        int[] test2 = {1,2,2,3,2};
        solution(test1);
        solution(test2);
    }
    static void solution(int[] nums) {
        int candidate1=0, candidate2=0;
        int count1=0, count2=0;

        // this loop to find the candidates
        for (int i : nums) {
            // only 1 of these stmts will execute (covers all edge cases)
            if (i == candidate1) count1++;
            else if (i == candidate2) count2++;
            else if (count1 == 0) candidate1=i;
            else if (count2 == 0) candidate2=i;
            else {
                count1--;
                count2--;
            }
        }

        // another loop to count their occurrence
        count1=0;
        count2=0;
        for (int i : nums) {
            if (i == candidate1) count1++;
            if (i == candidate2) count2++;
        }

        // checking for majority element with occurrence more than n/3
        if (count1 > nums.length/3) System.out.println(candidate1);
        if (count2 > nums.length/3) System.out.println(candidate2);
    }
}
