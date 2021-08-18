package s413;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 8, 9, 10};
        System.out.println(new Solution().numberOfArithmeticSlices(nums));

    }

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3) {
            return 0;
        }
        int[] dp = new int[5005];
        dp[0] = dp[1] = 0;
        int len = nums.length;
        int pre = nums[1] - nums[0];
        for (int i = 2; i < len; i++) {
            int ans = nums[i] - nums[i - 1];
            if (ans == pre) {
                dp[i] = dp[i - 1] + dp[i - 1] - dp[i - 2] + 1;
            } else {
                dp[i] = dp[i - 1];
            }
            pre = ans;
        }
        return dp[nums.length - 1];
    }
}
