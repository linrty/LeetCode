package s30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 16:39
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "wordgoodgoodgoodbestword";
        String[] words = {"word", "good", "best", "good"};
        System.out.println(new Solution().findSubstring(s, words));
    }

    public List<Integer> findSubstring(String s, String[] words) {
        int len = s.length();
        int size = words[0].length();
        int num = words.length;
        int length = num * size;
        List<Integer> list = new ArrayList<>();
        if (len < length) return list;
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < num; i++) {
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
        }
        int i = 0;
        int j = i + length;
        while (j <= len) {
            Map<String, Integer> mm = new HashMap<>();
            int l, r;
            l = i;
            r = l + size;
            boolean flag = true;
            while (r <= j) {
                String str = s.substring(l, r);
                if (map.containsKey(str) && map.get(str) >= mm.getOrDefault(str, 0) + 1) {
                    mm.put(str, mm.getOrDefault(str, 0) + 1);
                } else {
                    flag = false;
                    break;
                }
                l = r;
                r = l + size;
            }
            if (flag) list.add(i);
            i++;
            j++;
        }
        return list;
    }
}
