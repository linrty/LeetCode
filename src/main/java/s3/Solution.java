package s3;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        String s = "pwwkew";
        System.out.println(new Solution().lengthOfLongestSubstring(s));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s.equals("")) {
            return 0;
        }
        int[] dp = new int[50005];
        Arrays.fill(dp, 0);
        Map<Character, Integer> map = new HashMap<>();
        int len = s.length();
        dp[0] = 1;
        map.put(s.charAt(0), 0);
        int maxi = 1;
        for (int i = 1; i < len; i++) {
            char ch = s.charAt(i);
            if (map.containsKey(ch)) {
                int pos = map.get(ch);
                int num = Math.min(i - pos, dp[i - 1] + 1);
                dp[i] = num;
                maxi = Math.max(maxi, dp[i]);
                map.put(ch, i);
            } else {
                dp[i] = dp[i - 1] + 1;
                maxi = Math.max(maxi, dp[i]);
                map.put(ch, i);
            }
            //System.out.println(maxi);
        }
        return maxi;
    }
}
