package s27;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: Linrty
 * @Date: 2021/8/14 14:38
 * @Version: 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(new Solution().removeElement(nums, val));
    }

    /*
     * @Author Linrty
     * @Description: TODO
     * @Date 14:38 2021/8/14
     * @Param [nums, val]
     * @return int
     **/
    public int removeElement(int[] nums, int val) {
        int num = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[num] = nums[i];
                num++;
            }
        }
        return num;
    }
}
