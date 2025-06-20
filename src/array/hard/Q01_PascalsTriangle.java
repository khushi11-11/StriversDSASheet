package array.hard;

import java.util.Arrays;

/*
Program to generate Pascal's Triangle
Problem Statement: This problem has 3 variations. They are stated below:
Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.
Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.

In Pascal’s triangle, each number is the sum of the two numbers directly above it
Example 1:
Input Format: N = 5, r = 5, c = 3
Result: 6 (for variation 1)
1 4 6 4 1 (for variation 2)
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1    (for variation 3)

Explanation: There are 5 rows in the output matrix. Each row is formed using the logic of Pascal’s triangle.

Example 2:
Input Format: N = 1, r = 1, c = 1
Result: 1 (for variation 1)
    1 (for variation 2)
    1  (for variation 3)
Explanation: The output matrix has only 1 row.
 */
public class Q01_PascalsTriangle {
    public static void main(String[] args) {
        pascal(5,5,3);
        // n=size of 2d array (total rows)
        // r=row no., c=col no.
        pascal(1,1,1);
    }
    static void pascal(int n, int r, int c) {
        // building pascal's triangle
        int[][] matrix = new int[n][];
        for (int i = 0; i < n; i++) {
            matrix[i] = new int[i+1]; // initialize jagged array(member array of vble length) ? compiler doesn't kno the size of member array
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) matrix[i][j] = 1;
                else {
                    matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
                }
            }
        }

        // variation:1 (element at [r][c] of triangle, r=r-1,c=c-1 ? natural numbers exlude 0 of indexing
        System.out.println(matrix[r-1][c-1]);

        // variation:2 (print rth row -> r-1 row)
        System.out.println(Arrays.toString(matrix[r-1]));

        // variation:3
        for (int[] x : matrix) {
            System.out.println(Arrays.toString(x));
        }
        /*
        OR the triangle format :-
        for (int[] row : matrix) {
            if (row.length > 0) System.out.println(); // for new line
            for (int x : row) {
                System.out.print(x + " ");
            }
        }
         */
    }
}
