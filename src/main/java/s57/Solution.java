package s57;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 11:56
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int pos = -1;
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!flag && newInterval[0] <= intervals[i][1]) {
                if (newInterval[1] >= intervals[i][0]) {
                    flag = true;
                    if (newInterval[1] > intervals[i][1]) intervals[i][1] = newInterval[1];
                    if (newInterval[0] < intervals[i][0]) intervals[i][0] = newInterval[0];
                } else {
                    flag = true;
                    list.add(newInterval);
                    pos++;
                }

            }
            if (pos > -1 && intervals[i][0] <= list.get(pos)[1]) {
                if (intervals[i][1] > list.get(pos)[1]) {
                    list.get(pos)[1] = intervals[i][1];
                }
            } else {
                list.add(intervals[i]);
                pos++;
            }
        }
        if (!flag) {
            list.add(newInterval);
            pos++;
        }
        int[][] ans = new int[pos + 1][2];
        for (int i = 0; i <= pos; i++) {
            ans[i] = list.get(i);
        }
        return ans;

    }
}
