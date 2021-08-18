package s233;

public class Solution {
    public static void main(String[] args) {
        int n = 13;
        System.out.println(new Solution().countDigitOne(n));
    }

    public int countDigitOne(int n) {
        long[][] dp = new long[10][15];
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j < 10; j++) {
                if (j == 1) {
                    if (i == 1) {
                        dp[j][i] = 1;
                    } else {
                        dp[j][i] = dp[9][i - 1] + dp[1][i - 1];
                    }
                } else if (j == 2) {
                    dp[j][i] = dp[1][i] + dp[1][i] - 1 + (long) Math.pow(10, i - 1) - 1;
                } else {
                    dp[j][i] = dp[j - 1][i] + dp[1][i] - 1;
                }
            }
        }
        int num = 1000000000;
        int pos = 10;
        long ans = 0;
        while (n != 0) {
            int x = n / num;
            int y = n % num;
            num /= 10;
            n = y;
            ans += dp[x][pos];
            if (x == 1) {
                ans += y;
            }
            pos--;
        }
        return (int) ans;
    }
}
