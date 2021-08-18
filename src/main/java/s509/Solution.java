package s509;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().fib(4));
    }

    public int fib(int n) {
        if (n == 0 || n == 1) return n;
        if (n == 2) return 1;
        int a, b, c, d;
        a = 0;
        b = 1;
        c = 1;
        for (int i = 3; i <= n; i++) {
            d = a + b + c;
            a = b;
            b = c;
            c = d;
        }
        return c;
    }
}
