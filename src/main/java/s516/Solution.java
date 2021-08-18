package s516;

public class Solution {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(new Solution().longestPalindromeSubseq(s));
    }

    public int longestPalindromeSubseq(String s) {
        int len = s.length();
        int[][] dp = new int[1005][1005];
        for (int i = 0; i < len; i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                dp[j][i] = Math.max(dp[j + 1][i], dp[j][i - 1]);
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - 1 == j) {
                        dp[j][i] = 2;
                    } else {
                        dp[j][i] = Math.max(dp[j][i], dp[j + 1][i - 1] + 2);
                    }
                }
            }
        }
        return dp[0][len - 1];
    }
}
