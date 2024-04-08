package s5854;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/29 12:46
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {9,4,1,7};
        int k = 2;
        System.out.println(new Solution().minimumDifference(nums, k));
    }
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int i = 0;
        int j = i + k - 1;
        int len = nums.length;
        int mini = Integer.MAX_VALUE;
        while (j < len){
            mini = Math.min(mini,nums[j]-nums[i]);
            j++;
            i++;
        }
        return mini;
    }
}
