package array.medium;

import java.util.Arrays;
/*
SET MATRIX ZERO~
Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
Examples 1:
Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Explanation: Since matrix[2][2]=0.Therefore, the 2nd column and 2nd row wil be set to 0.
Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore, 1st row, 1st column and 4th column will be set to 0
 */
public class Q11_SetMatrixZero {
    public static void main(String[] args) {
        int[][] matrix1 = {{1,1,1}, {1,0,1}, {1,1,1}};
        int[][] matrix2 = {{0,1,2,0}, {3,4,5,2}, {0,3,1,0}};

//        bruteForce(matrix1);
//        better(matrix2);
        optimal(matrix2);
    }

    static void bruteForce(int[][] nums) { // works when there's only 1 zero
        int row=-1, col=-1;
        // checking for zeroes
        for (int i = 0; i < nums.length; i++)
            for (int j = 0; j < nums[i].length; j++)
                if (nums[i][j] == 0) {
                    row=i;
                    col=j;
                }

        // filling zeroes
        Arrays.fill(nums[row], 0); // ith row set to zero
        for (int i = 0; i < nums.length; i++) nums[i][col] = 0; // ith column of every row set to zero
        // displaying updated matrix
        for (int i = 0; i < nums.length; i++) System.out.println(Arrays.toString(nums[i]));

    }

    static void better(int[][] nums) {
        /*
        Boolean: def value= null
        boolean: def value= false
         */
        boolean[] row = new boolean[nums.length];
        boolean[] col = new boolean[nums[0].length];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (nums[i][j] == 0) {
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for (int i = 0; i < row.length; i++)
            for (int j = 0; j < col.length; j++)
                if (row[i] || col[j]) nums[i][j]=0;
                // bcoz they themselves hold the boolean value required for if condition

        for (int[] num : nums) System.out.println(Arrays.toString(num));
    }

    static void optimal(int[][] nums) {
        Boolean firstRowZero = false, firstColZero = false;

        // for first row -> nums[0][col]
        for (int col = 0; col < nums[0].length; col++) {
            if (nums[0][col] == 0) {
                firstRowZero=true;
                break;
            }
        }

        // for first column -> nums[row][0]
        for (int row = 0; row < nums.length; row++) {
            if (nums[row][0] == 0) {
                firstColZero=true;
                break;
            }
        }

        // setting zeroes
        for (int i = 1; i < nums.length; i++) {
            for (int j = 1; j < nums[i].length; j++) {
                if (nums[i][0] == 0 || nums[0][j] == 0)
                    nums[i][j] = 0;
            }
        }

        // handling first row and column
        if (firstRowZero) Arrays.fill(nums[0], 0);
        if (firstColZero) {
            for (int i = 0; i < nums.length; i++) nums[i][0]=0;
        }


        for (int[] i : nums) System.out.println(Arrays.toString(i));
    }
}





// in-place markers in row 0 and col 0 for any space constraint matrix problem