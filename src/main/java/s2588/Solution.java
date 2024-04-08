package s2588;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long beautifulSubarrays(int[] nums) {
        int pre[] = new int[nums.length];
        pre[0] = nums[0];
        for (int i=1;i<nums.length;i++) {
            pre[i] = pre[i-1] ^ nums[i];
        }
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0;i<nums.length;i++) {
            map.put(pre[i], map.getOrDefault(pre[i], 0) + 1);
        }
        for (int num:map.keySet()) {
            int cnt = map.get(num);
            res += (long)cnt * (cnt - 1) / 2;
        }
        return res;
    }
}
