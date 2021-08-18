package s977;


import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-4, -1, 0, 3, 10};
        System.out.println(Arrays.toString(new Solution().sortedSquares(nums)));
    }

    public int[] sortedSquares(int[] nums) {
        int[] ans = new int[nums.length];
        int sta, end;
        sta = 0;
        end = nums.length - 1;
        int pos = end;
        while (sta <= end) {
            nums[sta] = Math.abs(nums[sta]);
            nums[end] = Math.abs(nums[end]);
            if (nums[sta] > nums[end]) {
                ans[pos--] = nums[sta] * nums[sta];
                sta++;
            } else {
                ans[pos--] = nums[end] * nums[end];
                end--;
            }
        }
        return ans;
    }
}
