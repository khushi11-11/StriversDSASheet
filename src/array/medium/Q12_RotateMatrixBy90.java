package array.medium;

import java.util.Arrays;

/*
ROTATE IMAGE BY 90 DEGREE (basically, transpose)~
Problem Statement: Given a matrix, your task is to rotate the matrix 90 degrees clockwise.
Example 1:
Input: [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Example 2:
Input: [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output:[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

find row(x) ->col no of x :
    row(1,4,7)= col no = 0
    row(2,5,8)= col no = 1
    row(3,6,9)= col no = 2
find col no-> 2-row no :
    col(1,2,3)= 2-0 = 2
    col(4,5,6)= 2-1 = 1
    col(7,8,9)= 2-2 = 0
 */
public class Q12_RotateMatrixBy90 {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
//        bruteForce(matrix1);
        rotateMatrix(matrix1);
    }

    static void bruteForce(int[][] nums) {
        int[][] rotate = new int[nums.length][nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[0].length; j++) {
                rotate[j][nums.length-1 - i] = nums[i][j];
                // replaced [2-i] to [nums.length-1 - i] ?? for any dimension of matrix
            }
        }
        for (int[] i : rotate) {
            System.out.println(Arrays.toString(i));
        }
    }

    static void rotateMatrix(int[][] nums) {
        // STEP 01: transpose the matrix - rows to col, col to rows
        // STEP 02: reverse the elements of rows

        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                /*
                i+1 bcoz at every row the elements with (col no.<=their row no.) has already been swapped
                also ignores diagonal elements
                smartly skipped:
                > Diagonal (i == j)
                > Already-swapped parts (j < i)
                 */
                int temp = nums[i][j];
                nums[i][j] = nums[j][i];
                nums[j][i] = temp;
            }
        }


        for (int i = 0; i < nums.length; i++) {
            int left=0, right= nums.length-1;
            while (left < right) {
                int temp = nums[i][left];
                nums[i][left] = nums[i][right];
                nums[i][right] = temp;
                left++;
                right--;
            }
        }


        for (int[] i : nums) {
            System.out.println(Arrays.toString(i));
        }
    }
}
