package recursion;

public class Fibonacci {
    public static void main(String[] args) {
        int num = 50;
        long ans = fibo(num);
        System.out.println(ans);
//        print(5);
    }

    static long fibo(int i) {
        if (i<2) return i;
        return fibo(i-1) + fibo(i-2); // last fxn call - tail recursion
    }

    static void print(int i) {
        System.out.println(i);
        i--;
        if (i>0) print(i);
    }
}
