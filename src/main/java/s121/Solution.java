package s121;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 15:59
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        if (prices.length == 1) return 0;
        int pre = Math.min(prices[1], prices[0]);
        int maxi = prices[1] - prices[0];
        for (int i = 2; i < prices.length; i++) {
            maxi = Math.max(maxi, prices[i] - pre);
            pre = Math.min(pre, prices[i]);
        }
        if (maxi < 0) return 0;
        return maxi;
    }
}
