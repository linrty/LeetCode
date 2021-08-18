package s5;

public class Solution {
    public static void main(String[] args) {
        String s = "ac";
        System.out.println(new Solution().longestPalindrome(s));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[1005][1005];
        dp[0][0] = true;
        int maxSta = 0;
        int maxEnd = 0;
        int maxi = 1;
        for (int i = 1; i < len; i++) {
            dp[i][i] = true;
            if (s.charAt(i - 1) == s.charAt(i)) {
                dp[i - 1][i] = true;
                if (2 > maxi) {
                    maxSta = i - 1;
                    maxEnd = i;
                    maxi = 2;
                }
            }
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j][i - 1] && j > 0 && s.charAt(j - 1) == s.charAt(i)) {
                    dp[j - 1][i] = true;
                    if (i - j + 2 > maxi) {
                        maxSta = j - 1;
                        maxEnd = i;
                        maxi = i - j + 2;
                    }
                }
            }
        }
        String ans = s.substring(maxSta, maxEnd + 1);
        return ans;
    }
}
