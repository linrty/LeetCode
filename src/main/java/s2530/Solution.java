package s2530;

import java.util.*;

public class Solution {
    public long maxKelements(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return nums[o2] - nums[o1];
            }
        });
        for (int num:nums) {
            queue.add(num);
        }
        long res = 0;
        for (int i = 0;i < k;i++) {
            int num = queue.poll();
            res += num;
            if (num % 3 != 0) queue.add(num / 3 + 1);
            else queue.add(num / 3);
        }
        return res;
    }
}
