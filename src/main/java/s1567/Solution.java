package s1567;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 18:55
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, -2, -3, 4};
        System.out.println(new Solution().getMaxLen(nums));
    }


    public int getMaxLen(int[] nums) {
        int[] dp1, dp2;
        int maxi;
        dp1 = new int[nums.length];
        dp2 = new int[nums.length];
        if (nums[0] > 0) {
            maxi = dp1[0] = 1;
            dp2[0] = 0;
        } else if (nums[0] < 0) {
            dp2[0] = 1;
            maxi = dp1[0] = 0;
        } else {
            maxi = dp1[0] = dp2[0] = 0;
        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp1[i] = Math.max(1, dp1[i - 1] + 1);
                if (dp2[i - 1] != 0) dp2[i] = Math.max(0, dp2[i - 1] + 1);
                else dp2[i] = 0;
            } else if (nums[i] < 0) {
                if (dp2[i - 1] != 0) dp1[i] = Math.max(dp2[i - 1] + 1, 0);
                else dp1[i] = 0;
                dp2[i] = Math.max(1, dp1[i - 1] + 1);
            } else {
                dp1[i] = dp2[i] = 0;
            }
            maxi = Math.max(maxi, dp1[i]);
        }
        return maxi;
    }
}
