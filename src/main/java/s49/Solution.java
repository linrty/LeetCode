package s49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 20:33
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String[] strings = {"", "sdf"};
        System.out.println(new Solution().groupAnagrams(strings));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, Integer> maps = new HashMap<>();
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            int len = strs[i].length();
            int[] vis = new int[30];
            for (int j = 0; j < len; j++) {
                vis[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder s = new StringBuilder("");
            for (int j = 0; j < 26; j++) {
                if (vis[j] < 10) {
                    s.append("00");
                } else if (vis[j] < 100) {
                    s.append("0");
                }
                s.append(vis[j]);
            }
            if (maps.containsKey(s.toString())) {
                int index = maps.get(s.toString());
                list.get(index).add(strs[i]);
            } else {
                maps.put(String.valueOf(s), list.size());
                List<String> stringList = new ArrayList<>();
                stringList.add(strs[i]);
                list.add(stringList);
            }
        }
        return list;
    }
}
