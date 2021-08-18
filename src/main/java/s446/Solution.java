package s446;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {

        int[] nums = {79, 20, 64, 28, 67, 81, 60, 58, 97, 85, 92, 96, 82, 89, 46, 50, 15, 2, 36, 44, 54, 2, 90, 37, 7, 79, 26, 40, 34, 67, 64, 28, 60, 89, 46, 31, 9, 95, 43, 19, 47, 64, 48, 95, 80, 31, 47, 19, 72, 99, 28, 46, 13, 9, 64, 4, 68, 74, 50, 28, 69, 94, 93, 3, 80, 78, 23, 80, 43, 49, 77, 18, 68, 28, 13, 61, 34, 44, 80, 70, 55, 85, 0, 37, 93, 40, 47, 47, 45, 23, 26, 74, 45, 67, 34, 20, 33, 71, 48, 96};
        System.out.println(new Solution().numberOfArithmeticSlices(nums));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        Map<Integer, Map<Long, Integer>> map = new HashMap<>();
        int num = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            map.put(i, new HashMap<>());
            for (int j = 0; j < i; j++) {
                long sub = 1L * nums[i] - nums[j];
                Map<Long, Integer> nm = map.get(i);
                Map<Long, Integer> mm = map.get(j);
                int x = mm.getOrDefault(sub, 0);
                num += x;
                nm.put(sub, nm.getOrDefault(sub, 0) + x + 1);
                map.put(i, nm);
            }
        }
        return num;
    }
}


