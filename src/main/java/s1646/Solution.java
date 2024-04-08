package s1646;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/23 10:23
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public int getMaximumGenerated(int n) {
        if (n<2) return n;
        int[] nums = new int[n+5];
        int maxi = -1;
        for (int i = 2; i <= n; i++) {
            if (i%2 == 0) {
                nums[i] = nums[i/2];
            }else{
                nums[i] = nums[i/2] + nums[i/2 + 1];
            }
            maxi = Math.max(nums[i], maxi);
        }
        return maxi;
    }

}
