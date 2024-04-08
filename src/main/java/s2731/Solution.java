package s2731;

import java.util.Arrays;

public class Solution{
    public int sumDistance(int[] nums, String s, int d) {
        int len = nums.length;
        int mod = 1000000007;
        for (int i = 0;i < len;i++){
            if (s.charAt(i) == 'L'){
                nums[i] -= d;
            } else {
                nums[i] += d;
            }
        }
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0;i < len;i++){
            res = (res - (long)nums[i] * (len - i - 1)) % mod;
            res = (res + (long)nums[i] * i) % mod;
        }
        return (int)res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {-2,0,2};
        String str = "RLL";
        int d = 3;
        System.out.println(s.sumDistance(nums, str, d));
    }
}
