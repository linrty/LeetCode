package s10;

public class Solution {
    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(new Solution().isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[50][50];
        int len1 = s.length();
        int len2 = p.length();
        dp[0][0] = true;

        for (int i = 1; i <= len2; i++) {
            for (int j = 0; j <= len1; j++) {
                if (j != 0 && p.charAt(i - 1) >= 'a' && p.charAt(i - 1) <= 'z') {
                    if (p.charAt(i - 1) == s.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                    else dp[i][j] = false;
                } else if (p.charAt(i - 1) == '*') {
                    if (j != 0 && (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.')) {
                        dp[i][j] = (dp[i][j - 1] || dp[i - 2][j]);

                    } else {
                        dp[i][j] = dp[i - 2][j];
                    }
                } else if (j != 0 && p.charAt(i - 1) == '.') {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        return dp[len2][len1];
    }
}
