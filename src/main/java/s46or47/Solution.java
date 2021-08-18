package s46or47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 17:19
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1};
        System.out.println(new Solution().permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        lists.add(list);
        while (true) {
            int i = nums.length - 1;
            while (i > 0 && nums[i - 1] >= nums[i]) {
                i--;
            }
            if (i == 0) break;
            i--;
            int j = nums.length - 1;
            while (j < nums.length) {
                if (nums[j] > nums[i]) {
                    int t = nums[j];
                    nums[j] = nums[i];
                    nums[i] = t;
                    break;
                }
                j--;
            }
            j = nums.length - 1;
            i++;
            while (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
                i++;
                j--;
            }
            list = new ArrayList<>();
            for (int k = 0; k < nums.length; k++) {
                list.add(nums[k]);
            }
            lists.add(list);
        }
        return lists;
    }
}
