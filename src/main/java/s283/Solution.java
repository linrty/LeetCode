package s283;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Solution().moveZeroes(nums);
    }

    public void moveZeroes(int[] nums) {
        int[] ans = new int[nums.length];
        int pos = 0;
        for (int num : nums) {
            if (num != 0) ans[pos++] = num;
        }
        System.arraycopy(ans, 0, nums, 0, nums.length);
    }
}
