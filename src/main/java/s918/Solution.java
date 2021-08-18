package s918;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-2};
        System.out.println(new Solution().maxSubarraySumCircular(nums));
    }

    public int maxSubarraySumCircular(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int sum = nums[0];
        int maxi = nums[0];
        int mini = nums[nums.length - 1];
        dp1[0] = nums[0];
        dp2[nums.length - 1] = nums[nums.length - 1];
        //第一遍是正的
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            dp1[i] = nums[i];
            dp1[i] = Math.max(dp1[i], dp1[i - 1] + nums[i]);
            maxi = Math.max(maxi, dp1[i]);
        }
        //第二遍是逆的
        for (int i = nums.length - 2; i >= 0; i--) {
            dp2[i] = nums[i];
            dp2[i] = Math.min(dp2[i], dp2[i + 1] + nums[i]);
            mini = Math.min(mini, dp2[i]);
        }

        if (mini < 0 && mini != sum) {
            maxi = Math.max(maxi, sum - mini);
        }
        return maxi;
    }
}
