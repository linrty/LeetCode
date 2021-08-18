package s152;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 18:09
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int maxProduct(int[] nums) {
        int[] dp1 = new int[nums.length];
        int[] dp2 = new int[nums.length];
        int maxi = nums[0];
        dp1[0] = dp2[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp1[i] = Math.max(nums[i] * dp1[i - 1], Math.max(nums[i], nums[i] * dp2[i - 1]));
            maxi = Math.max(dp1[i], maxi);
            dp2[i] = Math.min(nums[i] * dp2[i - 1], Math.min(nums[i], nums[i] * dp1[i - 1]));
            maxi = Math.max(dp2[i], maxi);
        }
        return maxi;
    }
}
