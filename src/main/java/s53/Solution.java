package s53;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Solution().maxSubArray(nums));
    }

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxi = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = nums[i];
            dp[i] = Math.max(dp[i], dp[i - 1] + nums[i]);
            maxi = Math.max(maxi, dp[i]);
        }
        return maxi;
    }
}
