package s123;

public class Solution {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        int res1 = -prices[0], ans1 = 0;
        int res2 = -prices[0], ans2 = 0;
        for (int i = 0;i < len;i++){
            res1 = Math.max(res1, -prices[i]);
            ans1 = Math.max(ans1, res1 + prices[i]);
            res2 = Math.max(res2, ans1 - prices[i]);
            ans2 = Math.max(ans2, res2 + prices[i]);
        }
        return ans2;
    }
}
