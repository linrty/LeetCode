package s45;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {2, 3, 0, 1, 4};
        System.out.println(new Solution().jump(nums));
    }

    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, nums.length);
        dp[0] = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) continue;
            for (int j = i + 1; j <= Math.min(nums.length - 1, i + nums[i]); j++) {
                dp[j] = Math.min(dp[j], dp[i] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}
