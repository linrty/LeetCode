package s41;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 16:27
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {7, 8, 9, 11, 12};
        System.out.println(new Solution().firstMissingPositive(nums));
    }

    public int firstMissingPositive(int[] nums) {
        int t = 0;
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]) {
                t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
        }
        System.out.println(Arrays.toString(nums));
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) return j + 1;
        }
        return nums.length + 1;
    }
}
