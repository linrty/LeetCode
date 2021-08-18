package s44;

import java.util.Arrays;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 16:47
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "ho";
        String p = "**ho";
        System.out.println(new Solution().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[p.length() + 5][s.length() + 5];
        int len1 = s.length();
        int len2 = p.length();
        dp[0][0] = true;
        if ("".equals(s)) {
            for (int i = 0; i < len2; i++) {
                if (p.charAt(i) != '*') return false;
            }
            return true;
        }
        for (int i = 0; i < len2; i++) {
            if (p.charAt(i) == '*') dp[i + 1][0] = true;
            else break;
        }
        for (int i = 1; i <= len2; i++) {
            for (int j = 1; j <= len1; j++) {
                if (p.charAt(i - 1) == '*') {
                    dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 1]);
                } else if (p.charAt(i - 1) == '?') {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    System.out.println(j);
                    if (p.charAt(i - 1) != s.charAt(j - 1)) dp[i][j] = false;
                    else {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp[2]));
        return dp[len2][len1];
    }
}
