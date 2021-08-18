package s29;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 15:54
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().divide(-1010369383,
                -2147483648));
    }

    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        if (divisor == Integer.MIN_VALUE) {
            if (dividend == Integer.MIN_VALUE) return 1;
            else return 0;
        }
        int xx = 0;
        int i = Math.abs(divisor);
        while (i != 0) {
            i = i >> 1;
            xx++;
        }
        boolean flag = false;
        if ((dividend < 0 && divisor > 0) || (dividend > 0 && divisor < 0)) flag = true;
        dividend = -Math.abs(dividend);
        divisor = -Math.abs(divisor);


        int ans = 0;
        while (dividend <= divisor) {
            int x = 1;
            int num = divisor;
            int nn = 32 - xx;
            while (nn > 1 && dividend < (num << 1)) {
                x = x << 1;
                num = num << 1;
                nn--;
            }
            dividend -= num;
            ans += x;
        }
        if (flag) ans = -ans;
        return ans;
    }
}
