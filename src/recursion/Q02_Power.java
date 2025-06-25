package recursion;
/*
Implement Pow(x,n) | X raised to the power N~
Problem Statement: Given a double x and integer n, calculate x raised to power n. Basically Implement pow(x, n).
Example 1:
Input: x = 2.00000, n = 10
Output: 1024.00000
Example 2:
Input: x = 2.10000, n = 3
Output: 9.26100
 */
public class Q02_Power {
    public static void main(String[] args) {
        double x = 2.10000;
        int n = 3;
        double ans = power(x,n,1.00000);
        System.out.println(ans);
    }

    static double power(double num, int pow, double res) {
        if (pow == 0) return res;
        res *= num;
        pow--;
        return power(num,pow,res);
    }
}
