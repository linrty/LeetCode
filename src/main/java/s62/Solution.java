package s62;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 15:25
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m + 5][n + 5];
        dp[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 1 && j == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m][n];
    }
}
