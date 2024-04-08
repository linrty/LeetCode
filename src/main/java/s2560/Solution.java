package s2560;

public class Solution {
    public int minCapability(int[] nums, int k) {
        int maxv = Integer.MIN_VALUE;
        int minv = Integer.MAX_VALUE;
        for (int num: nums){
            maxv = Math.max(maxv, num);
            minv = Math.min(minv, num);
        }
        while (maxv >= minv){
            int mid = (maxv + minv) / 2;
            int cnt = 0;
            boolean flag = false;
            for (int num: nums){
                if (num <= mid && !flag) {
                    cnt++;
                    flag = true;
                }else {
                    flag = false;
                }
            }
            if (cnt >= k){
                // 说明小于mid的数在这个半区有足够k个，可以继续缩小
                maxv = mid - 1;
            }else {
                // 说明小于mid的数在这个半区不够k个，需要扩大
                minv = mid + 1;
            }
        }
        return minv;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {7,3,9,5};
        int k = 2;
        System.out.println(s.minCapability(nums, k));
    }
}

// 复杂度 O(nlogn)
