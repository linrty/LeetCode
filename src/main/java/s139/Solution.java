package s139;

import java.util.*;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 20:03
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("dog");
        list.add("s");
        list.add("gs");
        System.out.println(new Solution().wordBreak("dogs", list));
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Map<String, Boolean> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        boolean[] dp = new boolean[s.length() + 5];
        for (int i = 0; i < wordDict.size(); i++) {
            map.put(wordDict.get(i), true);
            set.add(wordDict.get(i).length());
        }
        int len = s.length();
        dp[0] = true;
        for (int i = 0; i < len; i++) {
            for (Integer j : set) {
                int num = i - j + 1;
                if (num >= 0) {
                    String str = s.substring(num, i + 1);
                    if (map.containsKey(str)) {
                        dp[i + 1] = dp[num];
                    }
                }
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[s.length()];
    }
}
