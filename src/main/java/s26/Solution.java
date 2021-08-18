package s26;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: Linrty
 * @Date: 2021/8/14 14:28
 * @Version: 1.0
 **/
public class Solution {
    /*
     * @Author Linrty
     * @Description //TODO
     * @Date 14:29 2021/8/14
     * @Param [args]
     * @return void
     **/
    public static void main(String[] args) {
        int[] nums = {};
        System.out.println(new Solution().removeDuplicates(nums));
    }

    /*
     * @Author Linrty
     * @Description: TODO
     * @Date 14:30 2021/8/14
     * @Param [nums]
     * @return int
     **/
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int num = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }
}
