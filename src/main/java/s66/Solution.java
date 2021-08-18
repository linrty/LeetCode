package s66;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 21:12
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[] digits = {9, 5, 9, 9, 9};
        System.out.println(Arrays.toString(new Solution().plusOne(digits)));
    }

    public int[] plusOne(int[] digits) {
        int len = digits.length - 1;
        int pre = 1;
        while (len >= 0) {
            int num = (pre + digits[len]) % 10;
            pre = (pre + digits[len]) / 10;
            digits[len] = num;
            len--;
        }
        if (pre != 0) {
            int[] ans = new int[digits.length + 1];
            ans[0] = pre;
            System.arraycopy(ans, 1, digits, 0, digits.length);
            return ans;
        }
        return digits;
    }
}
