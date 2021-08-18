package s714;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 16:41
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int maxProfit(int[] prices, int fee) {
        if (prices.length == 1) return 0;
        int dp[] = new int[prices.length];
        dp[1] = prices[1] - prices[0] - fee;
        int maxi, maxj;
        maxi = Math.max(0, dp[1]);
        maxj = 0;
        for (int i = 2; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1] - prices[i - 1] + prices[i], maxj - prices[i - 1] + prices[i] - fee);
            maxi = Math.max(maxi, dp[i]);
            maxj = Math.max(maxj, dp[i - 1]);
        }
        return maxi;
    }
}
