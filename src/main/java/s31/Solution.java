package s31;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 17:35
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution().nextPermutation(nums);

    }

    public void nextPermutation(int[] nums) {
        int len = nums.length;
        len--;
        int t = 0;
        int sta = 0;
        int end = 0;
        int pos = len;
        while (pos > 0) {
            if (nums[pos] > nums[pos - 1]) {
                System.out.println(Arrays.toString(nums));
                for (int i = len; i >= pos; i--) {
                    if (nums[i] > nums[pos - 1]) {
                        t = nums[i];
                        nums[i] = nums[pos - 1];
                        nums[pos - 1] = t;
                        break;
                    }
                }

                sta = pos;
                end = len;
                while (sta < end) {
                    t = nums[sta];
                    nums[sta] = nums[end];
                    nums[end] = t;
                    sta++;
                    end--;
                }
                return;
            }
            pos--;
        }
        end = len;
        while (sta < end) {
            t = nums[sta];
            nums[sta] = nums[end];
            nums[end] = t;
            sta++;
            end--;
        }
        return;
    }
}
