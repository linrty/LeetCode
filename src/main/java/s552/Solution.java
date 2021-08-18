package s552;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 10:31
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().checkRecord(10101));
    }

    public int checkRecord(int n) {
        final long MOD = 1000000007L;
        long[][] dp = new long[n + 5][3];
        dp[1][0] = 2;
        dp[1][1] = 1;
        dp[0][0] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i][0] = dp[i - 1][0];
            dp[i][1] = (dp[i - 1][1] + dp[i - 1][0]) % MOD;
            if (i - 3 > 0) {
                dp[i][0] += ((MOD + dp[i - 1][0] - dp[i - 4][0]) % MOD);
                dp[i][1] += (((MOD + dp[i - 1][1] - dp[i - 4][1]) % MOD + MOD - dp[i - 4][0]) % MOD);
            } else {
                dp[i][0] += (dp[i - 1][0]);
                dp[i][1] += (dp[i - 1][1]);
                if (i == 3) dp[i][0]--;
            }
        }
        return (int) ((dp[n][0] + dp[n][1]) % MOD);
    }
}