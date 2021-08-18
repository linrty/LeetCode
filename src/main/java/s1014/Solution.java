package s1014;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 15:50
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] values = {8, 1, 5, 2, 6};
        System.out.println(new Solution().maxScoreSightseeingPair(values));
    }

    public int maxScoreSightseeingPair(int[] values) {
        int[] dp = new int[values.length + 5];
        dp[1] = values[0] + values[1] - 1;
        int maxi = -1;
        for (int i = 2; i < values.length; i++) {
            dp[i] = Math.max(values[i] + values[i - 1] - 1, dp[i - 1] - 1 + values[i] - values[i - 1]);
            maxi = Math.max(maxi, dp[i]);
        }
        System.out.println(Arrays.toString(dp));
        return maxi;
    }
}
