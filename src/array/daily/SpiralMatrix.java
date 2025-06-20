package array.daily;

import java.util.ArrayList;
import java.util.List;

/*
input1:
int[][] matrix = {
    {1, 2, 3},
    {4, 5, 6},
    {7, 8, 9}
};
output1:
[1, 2, 3, 6, 9, 8, 7, 4, 5]
TRAVERSAL PATTERN:
We move in 4 directions:
➡️ Left to Right (top row)
⬇️ Top to Bottom (right column)
⬅️ Right to Left (bottom row)
⬆️ Bottom to Top (left column)
Then shrink the boundary and repeat!
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        }; // perfect square
        int[][] matrix2 = {
                {1},
                {2},
                {3},
                {4}
        }; // single column : won't work if second 'if-cond' is removed
        int[][] matrix3 = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9, 10, 11, 12}
        }; // rectangular
        int[][] matrix4 = {
                {1, 2}
        }; // single row : won't work if first 'if-cond' is removed

        solution(matrix1);
        solution(matrix2);
        solution(matrix3);
        solution(matrix4);
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

/*
The inner if-conds may be redundant, as the loop itself already says:
while (top <= bottom && left <= right)
*Not redundant — they're safety nets for mid-loop boundary changes.*

The loop condition ensures: “The start of a spiral cycle is safe.”
But the inner directions may still become invalid midway — because you're shrinking the boundaries inside the loop.

At the start of the loop, top <= bottom and left <= right are true.
But then... you do:
top++ and right--
Which means:
top may now be > bottom
or left > right
 */

