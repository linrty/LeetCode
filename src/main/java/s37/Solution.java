package s37;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 14:28
 * @Version 1.0
 **/
public class Solution {
    public char[][] vis;
    List<Point> pointList = new ArrayList<>();
    int len = 0;

    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        vis = board;
        init();
        dfs(0);
    }

    public boolean dfs(int pos) {
        if (pos == len) {
            return true;
        }
        Point point = new Point(pointList.get(pos).x, pointList.get(pos).y);
        for (int i = 1; i <= 9; i++) {
            vis[point.x][point.y] = (char) ('0' + i);
            if (judge(point.x, point.y)) {
                if (dfs(pos + 1)) return true;
                else {
                    vis[point.x][point.y] = '.';
                }
            } else {
                vis[point.x][point.y] = '.';
            }
        }
        return false;
    }

    public void init() {
        for (int i = 0; i < vis.length; i++) {
            for (int j = 0; j < vis[i].length; j++) {
                if (vis[i][j] == '.') pointList.add(new Point(i, j));
            }
        }
        len = pointList.size();
    }

    public boolean judge(int x, int y) {
        Set<Character> set = new HashSet<>();
        set.clear();
        for (int i = 0; i < 9; i++) {
            if (vis[x][i] == '.') continue;
            if (!set.contains(vis[x][i])) {
                set.add(vis[x][i]);
            } else {
                return false;
            }
        }
        set.clear();
        for (int i = 0; i < 9; i++) {
            if (vis[i][y] == '.') continue;
            if (!set.contains(vis[i][y])) {
                set.add(vis[i][y]);
            } else {
                return false;
            }
        }
        int xup, xend, yup, yend;
        xup = x * 3;
        xend = ((x + 1) * 3);
        yup = y * 3;
        yend = (y + 1) * 3;
        set.clear();
        for (int i = xup; i < xend; i++) {
            for (int j = yup; j < yend; j++) {
                if (vis[i][j] == '.') continue;
                if (!set.contains(vis[i][j])) {
                    set.add(vis[i][j]);
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public class Point {
        public int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
