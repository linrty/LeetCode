package s189;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {1};
        int k = 1;
        new Solution().rotate(nums, k);
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        int kk = k % len;
        if (kk == 0) {
            System.out.println(Arrays.toString(nums));
            return;
        }
        int sta = 0;
        int end = len - 1;
        while (sta < end) {
            int tt = nums[sta];
            nums[sta] = nums[end];
            nums[end] = tt;
            sta++;
            end--;
        }
        sta = kk;
        end = len - 1;
        while (sta < end) {
            int tt = nums[sta];
            nums[sta] = nums[end];
            nums[end] = tt;
            sta++;
            end--;
        }
        sta = 0;
        end = kk - 1;
        while (sta < end) {
            int tt = nums[sta];
            nums[sta] = nums[end];
            nums[end] = tt;
            sta++;
            end--;
        }
        System.out.println(Arrays.toString(nums));
    }

}
