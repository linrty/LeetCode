package s213;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {7, 7, 9, 5, 5, 10};
        System.out.println(new Solution().rob(nums));
    }

    public int rob(int[] nums) {
        int[] dp = new int[105];
        dp[0] = 0;
        dp[1] = nums[0];
        if (nums.length == 1) return dp[1];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length - 1; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1]);
        }

        int[] dp2 = new int[105];
        dp2[0] = 0;
        dp2[1] = 0;
        if (nums.length == 1) return dp[1];
        dp2[2] = nums[1];
        for (int i = 3; i <= nums.length; i++) {
            dp2[i] = Math.max(dp2[i - 1], Math.max(dp2[i - 2], dp2[i - 3]) + nums[i - 1]);
        }
        return Math.max(dp[nums.length - 1], dp2[nums.length]);
    }
}
