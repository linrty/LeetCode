package s576;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 10:28
 * @Version 1.0
 **/
public class Solution {
    public static final int MOD = 1000000007;

    public static void main(String[] args) {
        int m = 10;
        int n = 10;
        int maxMove = 0;
        int startRow = 5;
        int startColumn = 5;
        System.out.println(new Solution().findPaths(m, n, maxMove, startRow, startColumn));
    }

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][][] dp = new int[m + 5][n + 5][maxMove + 1];
        int[] tx = {0, 0, 1, -1};
        int[] ty = {1, -1, 0, 0};
        int ans = 0;
        dp[startRow + 1][startColumn + 1][0] = 1;
        for (int i = 1; i < maxMove; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = 1; k <= n; k++) {
                    for (int l = 0; l < 4; l++) {
                        dp[j][k][i] = (dp[j][k][i] + dp[j + tx[l]][k + ty[l]][i - 1]) % MOD;
                    }
                }
            }
        }
        for (int i = 0; i < maxMove; i++) {
            for (int j = 1; j <= m; j++) {
                ans = (ans + dp[j][1][i]) % MOD;
                ans = (ans + dp[j][n][i]) % MOD;
            }
            for (int j = 1; j <= n; j++) {
                ans = (ans + dp[1][j][i]) % MOD;
                ans = (ans + dp[m][j][i]) % MOD;
            }
        }
        return ans;
    }

}
