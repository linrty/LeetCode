package s50;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 21:08
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().myPow(2.0, Integer.MIN_VALUE));
    }

    public double myPow(double x, int n) {
        double res = 1.0;
        long ans = n;
        if (ans < 0) {
            x = 1.0 / x;
            ans = -ans;
        }
        while (ans > 0) {
            if (ans % 2 == 1) {
                res = res * x;
            }
            x = x * x;
            ans >>= 1;
        }
        return res;
    }
}
