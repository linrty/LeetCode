package s567;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 17:52
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s1 = "a";
        String s2 = "a";
        System.out.println(new Solution().checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> map = new HashMap<>();
        int len1 = s1.length();
        for (int i = 0; i < len1; i++) {
            map.put(s1.charAt(i), map.getOrDefault(s1.charAt(i), 0) + 1);
        }
        int len2 = s2.length();
        for (int i = 0; i < len2; i++) {
            Map<Character, Integer> mm = new HashMap<>();
            int j = i + len1;
            if (j > len2) break;
            int k = i;
            boolean flag = true;
            while (k < j) {
                if (mm.getOrDefault(s2.charAt(k), 0) + 1
                        > map.getOrDefault(s2.charAt(k), 0)) {
                    flag = false;
                    break;
                }
                mm.put(s2.charAt(k), mm.getOrDefault(s2.charAt(k), 0) + 1);
                k++;
            }
            if (flag) return true;
        }
        return false;
    }
}
