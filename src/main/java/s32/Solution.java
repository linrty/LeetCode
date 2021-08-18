package s32;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 20:47
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "(((()(()";
        System.out.println(new Solution().longestValidParentheses(s));
    }

    public int longestValidParentheses(String s) {
        int num = 0;
        int i = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int[] dp = new int[s.length() + 5];
        map.put(0, 0);
        int len = s.length();
        int maxi = 0;
        while (i < len) {
            if (s.charAt(i) == '(') {
                num++;
            } else {
                num--;
            }
            if (num <= 0) {
                if (num == 0) {
                    dp[i + 1] = i - map.get(num) + 1 + dp[map.get(num)];
                } else {
                    dp[i + 1] = 0;
                }
                map.clear();
                map.put(0, i + 1);
                num = 0;
            } else {
                if (s.charAt(i) == ')' && map.containsKey(num)) {
                    dp[i + 1] = i - map.get(num) + 1 + dp[map.get(num)];
                } else {
                    map.put(num, i + 1);
                }
            }
            maxi = Math.max(maxi, dp[i + 1]);
            i++;
        }
        return maxi;
    }
}
