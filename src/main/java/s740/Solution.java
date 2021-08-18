package s740;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 4, 2};
        System.out.println(new Solution().deleteAndEarn(nums));
    }

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[nums.length];
        Arrays.sort(nums);
        int pos = 0;
        ans[0] = nums[0];
        pos++;
        map.put(nums[0], 1);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                map.put(nums[i], 1);
                ans[pos++] = nums[i];
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int[] dp = new int[20005];
        dp[0] = 0;
        dp[1] = map.get(ans[0]) * ans[0];
        if (pos == 1) return dp[1];
        if (ans[0] + 1 == ans[1]) {
            dp[2] = Math.max(dp[1], ans[1] * map.get(ans[1]));
        } else {
            dp[2] = dp[1] + ans[1] * map.get(ans[1]);
        }
        for (int i = 3; i <= pos; i++) {
            dp[i] = dp[i - 1];
            if (ans[i - 2] + 1 != ans[i - 1]) {
                dp[i] = dp[i - 1] + ans[i - 1] * map.get(ans[i - 1]);
                System.out.println(dp[i]);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + ans[i - 1] * map.get(ans[i - 1]));

            }
        }
        return dp[pos];
    }
}
