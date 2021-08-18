package s91;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 20:21
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "2101";
        System.out.println(new Solution().numDecodings(s));
    }

    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 5];
        int len = s.length();
        if (s.charAt(0) == '0') return 0;
        dp[1] = 1;
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0' || s.charAt(i - 1) > '2') return 0;
                dp[i + 1] = dp[i - 1];
            } else {
                if (s.charAt(i - 1) == '0') {
                    dp[i + 1] = dp[i];
                } else {
                    int num = (s.charAt(i - 1) - '0') * 10 + (s.charAt(i) - '0');
                    if (num > 26) {
                        dp[i + 1] = dp[i];
                    } else {
                        dp[i + 1] = dp[i - 1] + dp[i];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[len];
    }
}
