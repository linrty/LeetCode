package s16;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;
        System.out.println(new Solution().threeSumClosest(nums, target));
    }

    //O(n^2logn)
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int mini = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                int pos = Arrays.binarySearch(nums, target - (nums[i] + nums[j]));
                if (pos >= 0 && pos < j) continue;
                if (pos < 0) {
                    pos = -pos - 1;
                    if (pos >= 0 && pos < j) continue;
                    if (pos == j) {
                        if (j + 1 < nums.length) {
                            if (Math.abs(target - (nums[pos + 1] + nums[i] + nums[j])) < Math.abs(target - mini)) {
                                mini = nums[pos + 1] + nums[i] + nums[j];
                            }
                        }
                        continue;
                    }

                    if (pos == nums.length) {
                        if (j != pos - 1 && Math.abs(target - (nums[pos - 1] + nums[i] + nums[j])) < Math.abs(target - mini)) {
                            mini = nums[pos - 1] + nums[i] + nums[j];
                        }
                        continue;
                    }
                    if (j == pos - 1 || Math.abs(target - (nums[pos] + nums[i] + nums[j])) < Math.abs(target - nums[pos - 1] + nums[i] + nums[j])) {
                        if (Math.abs(target - (nums[pos] + nums[i] + nums[j])) < Math.abs(target - mini)) {
                            mini = nums[pos] + nums[i] + nums[j];
                        }
                    } else {
                        if (j != pos - 1 && Math.abs(target - (nums[pos - 1] + nums[i] + nums[j])) < Math.abs(target - mini)) {
                            mini = nums[pos - 1] + nums[i] + nums[j];
                        }
                    }
                } else if (pos == j) {
                    if (j + 1 < nums.length) {
                        if (Math.abs(target - (nums[pos + 1] + nums[i] + nums[j])) < Math.abs(target - mini)) {
                            mini = nums[pos + 1] + nums[i] + nums[j];
                        }
                    }
                } else {
                    return target;
                }

            }
        }
        return mini;
    }

}
