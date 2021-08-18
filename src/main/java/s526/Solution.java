package s526;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 10:46
 * @Version 1.0
 **/
public class Solution {
    Map<Integer, Boolean> map = new HashMap<>();

    public static void main(String[] args) {
        System.out.println(new Solution().countArrangement(0));
    }

    public int countArrangement(int n) {
        if (n == 0) return 0;
        return dfs(1, n);
    }

    public int dfs(int pos, int n) {
        if (pos > n) return 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (pos % i == 0 || i % pos == 0) {
                if (!map.getOrDefault(i, false)) {
                    map.put(i, true);
                    ans += dfs(pos + 1, n);
                    map.put(i, false);
                }
            }
        }
        return ans;
    }
}
