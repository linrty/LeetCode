package s1;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        System.out.println(Arrays.toString(new Solution().twoSum(nums, target)));

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, List> mm = new HashMap<>();
        int[] ans = new int[2];
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (mm.containsKey(nums[i])) {
                List list = mm.get(nums[i]);
                list.add(i);
                mm.put(nums[i], list);
            } else {
                List list = new ArrayList();
                list.add(i);
                mm.put(nums[i], list);
            }

        }
        for (int i = 0; i < len; i++) {
            int num = target - nums[i];
            if (num != nums[i]) {
                if (mm.containsKey(num)) {
                    ans[0] = i;
                    List list = mm.get(num);
                    ans[1] = (Integer) list.get(0);
                    return ans;
                }
            } else {
                List list = mm.get(num);
                if (list.size() == 1) continue;
                else {
                    ans[0] = i;
                    int nn = (Integer) list.get(0);
                    if (nn == i) {
                        ans[1] = (Integer) list.get(1);
                    } else {
                        ans[1] = (Integer) list.get(0);
                    }
                    return ans;
                }
            }
        }
        return ans;
    }
}
