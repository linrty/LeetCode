package s994;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 19:48
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int orangesRotting(int[][] grid) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    Point a = new Point(i, j);
                    q.add(a);
                    vis[i][j] = true;
                }
            }
        }
        int tx[] = {1, -1, 0, 0};
        int ty[] = {0, 0, 1, -1};
        int mini = 0;
        while (!q.isEmpty()) {
            Point a = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = a.x + tx[i];
                int yy = a.y + ty[i];
                if (xx >= 0 && xx < grid.length && yy >= 0 && yy < grid[0].length && !vis[xx][yy] && grid[xx][yy] == 1) {
                    Point b = new Point(xx, yy);
                    b.step = a.step + 1;
                    mini = Math.max(mini, b.step);
                    grid[xx][yy] = 2;
                    q.add(b);
                    vis[xx][yy] = true;
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) return -1;
            }
        }
        return mini;
    }

    public class Point {
        public int x, y;
        public int step = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point() {
        }
    }
}
