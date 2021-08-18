package s198;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        System.out.println(new Solution().rob(nums));
    }

    public int rob(int[] nums) {
        int[] dp = new int[105];
        dp[0] = 0;
        dp[1] = nums[0];
        if (nums.length == 1) return dp[1];
        dp[2] = Math.max(nums[0], nums[1]);
        for (int i = 3; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], Math.max(dp[i - 2], dp[i - 3]) + nums[i - 1]);
        }

        return dp[nums.length];
    }
}
