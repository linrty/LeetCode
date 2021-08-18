package s1583;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        int[][] preferences = {{1}, {0}};
        int[][] pairs = {{0, 1}};
        int n = 2;
        System.out.println(new Solution().unhappyFriends(n, preferences, pairs));
    }

    public int unhappyFriends(int n, int[][] preferences, int[][] pairs) {
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer>[] all = new Map[n];
        Set<Integer> set = new HashSet<>();
        //记住序号
        for (int i = 0; i < n; i++) {
            all[i] = new HashMap<>();
            for (int j = 0; j < n - 1; j++) {
                all[i].put(preferences[i][j], j);
            }
        }
        //配对好
        for (int i = 0; i < n / 2; i++) {
            map.put(pairs[i][0], pairs[i][1]);
            map.put(pairs[i][1], pairs[i][0]);
        }

        int num = 0;

        for (int i = 0; i < n / 2; i++) {
            int x = pairs[i][0];
            int y = pairs[i][1];
            for (int j = 0; j < n; j++) {
                if (j == x || j == y) continue;
                // x 和 j
                int k = map.get(j);
                if (all[x].get(j) < all[x].get(y) && all[j].get(x) < all[j].get(k)) {
                    if (!set.contains(x)) {
                        set.add(x);
                        num++;
                    }
                    if (!set.contains(j)) {
                        set.add(j);
                        num++;
                    }
                }

                //y 和 j
                if (all[y].get(j) < all[y].get(x) && all[j].get(y) < all[j].get(k)) {
                    if (!set.contains(y)) {
                        set.add(y);
                        num++;
                    }
                    if (!set.contains(j)) {
                        set.add(j);
                        num++;
                    }
                }
            }
        }
        return num;
    }
}
