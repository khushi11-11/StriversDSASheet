package array.medium;

import java.util.ArrayList;
import java.util.List;

/*
SPIRAL TRAVERSAL OF MATRIX~
Problem Statement: Given a Matrix, print the given matrix in spiral order.
Example 1:
Input: Matrix[][] = { { 1, 2, 3, 4 },
		      { 5, 6, 7, 8 },
		      { 9, 10, 11, 12 },
	              { 13, 14, 15, 16 } }
Output: 1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10.
Explanation: The output of matrix in spiral form.

Example 2:
Input: Matrix[][] = { { 1, 2, 3 },
	              { 4, 5, 6 },
		      { 7, 8, 9 } }
Output: 1, 2, 3, 6, 9, 8, 7, 4, 5.
 */
public class Q13_SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        int[][] matrix2 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        solution(matrix1);
        solution(matrix2);
    }
    static void solution(int[][] nums) {
        int top=0; // element of top row
        int right=nums[0].length-1; // last (col) element of a row
        int bottom=nums.length-1; // last row
        int left=0; // first col

        List<Integer> spiral = new ArrayList<>();

        // go right->bottom->left->right in a loop
        // loop would be : top-to-bottom, left-to-right => top<bottom, left<right

        while (top<=bottom && left<=right) {
            // (top row):left to right, same row:top
            for (int i = left; i <= right; i++) //direction
                spiral.add(nums[top][i]); //which row or col
            top++;
            // (right col):top to bottom, same column:right
            for (int i = top; i <= bottom; i++)
                spiral.add(nums[i][right]);
            right--;

            /*
            The if (top <= bottom) and if (left <= right) checks:
            > Prevent duplicate traversals
            > Stop index out-of-bounds crashes
            > Handle odd dimensions & single row/column edge cases
             */

            // (bottom row): right to left, same row:bottom
            if (top<=bottom) { // -> single rows
                for (int i = right; i >= left; i--)
                    spiral.add(nums[bottom][i]);
                bottom--;
            }

            // (left col): bottom to top, same column:left
            if (left<=right) { // -> single cols
                for (int i = bottom; i >= top; i--)
                    spiral.add(nums[i][left]);
                left++;
            }
        }
        System.out.println(spiral);


        /*
        The two if checks:
            if (top <= bottom) { ... }
            if (left <= right) { ... }
        Are safety checks — to prevent *duplicate traversal* or out-of-bound access when the matrix is:
        1. odd-sized
        2. non-square
        3. shrinking to a single row or column
         */
    }
}
