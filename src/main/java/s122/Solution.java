package s122;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 16:16
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int[] dp = new int[prices.length];
        dp[1] = prices[1] - prices[0];
        int maxi = Math.max(dp[1], 0);
        int maxj = 0;
        for (int i = 2; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] - prices[i - 1] + prices[i], maxj + prices[i] - prices[i - 1]);
            maxi = Math.max(dp[i], maxi);
            maxj = Math.max(maxj, dp[i - 1]);
        }
        return maxi;
    }
}
