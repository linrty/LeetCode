package s56;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 11:16
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println(new Solution().merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) return -1;
            else if (o1[0] > o2[0]) return 1;
            else {
                if (o1[1] < o2[1]) return 1;
                else if (o1[1] == o2[1]) return 0;
                else return -1;
            }
        });
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);
        int pos = 0;
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < list.get(pos)[1] + 1) {
                if (intervals[i][1] > list.get(pos)[1]) {
                    list.get(pos)[1] = intervals[i][1];
                }
            } else {
                list.add(intervals[i]);
                pos++;
            }
        }
        int[][] ans = new int[pos + 1][2];
        for (int i = 0; i < pos + 1; i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }
}
