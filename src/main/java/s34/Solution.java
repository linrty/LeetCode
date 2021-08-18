package s34;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 11:55
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {};
        int target = 6;
        System.out.println(Arrays.toString(new Solution().searchRange(nums, target)));
    }

    public int[] searchRange(int[] nums, int target) {
        int x = Arrays.binarySearch(nums, target);
        if (x < 0) return new int[]{-1, -1};
        else {
            int pre = x;
            while (pre > 0 && nums[pre] == nums[pre - 1]) pre--;
            int end = x;
            while (end < nums.length - 1 && nums[end] == nums[end + 1]) end++;
            return new int[]{pre, end};
        }
    }
}
