package s55;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(new Solution().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        int maxi = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxi) {
                maxi = Math.max(maxi, i + nums[i]);
            } else {
                return false;
            }
        }
        return true;
    }
}
