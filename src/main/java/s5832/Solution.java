package s5832;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 20:00
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int[] rearrangeArray(int[] nums) {
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i - 1] + nums[i + 1] == 2 * nums[i]) {
                if (i == nums.length - 2) {
                    if (i - 2 >= 1) {
                        if (nums[i - 2] * 2 == nums[i - 3] + nums[i]) {
                            int t1, t2, t3;
                            t1 = nums[i - 1];
                            t2 = nums[i];
                            t3 = nums[i + 1];
                            if (nums[i - 1] * 2 == nums[i - 2] + nums[i + 1]) {
                                nums[i - 1] = t3;
                                nums[i] = t1;
                                nums[i + 1] = t2;
                            } else {
                                nums[i - 1] = t1;
                                nums[i] = t3;
                                nums[i + 1] = t2;
                            }
                        } else {
                            int t = nums[i - 1];
                            nums[i - 1] = nums[i];
                            nums[i] = t;
                        }
                    } else {
                        int t = nums[i - 1];
                        nums[i - 1] = nums[i];
                        nums[i] = t;
                    }
                } else {
                    int t = nums[i + 1];
                    nums[i + 1] = nums[i + 2];
                    nums[i + 2] = t;
                }
            }
        }
        return nums;
    }

}
