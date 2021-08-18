package s542;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 19:39
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {
        Queue<Point> q = new LinkedList<>();
        boolean[][] vis = new boolean[mat.length][mat[0].length];
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                if (mat[i][j] == 0) {
                    Point a = new Point(i, j);
                    q.add(a);
                    vis[i][j] = true;
                }
            }
        }
        int tx[] = {1, -1, 0, 0};
        int ty[] = {0, 0, 1, -1};
        while (!q.isEmpty()) {
            Point a = q.poll();
            for (int i = 0; i < 4; i++) {
                int xx = a.x + tx[i];
                int yy = a.y + ty[i];
                if (xx >= 0 && xx < mat.length && yy >= 0 && yy < mat[0].length && !vis[xx][yy]) {
                    Point b = new Point(xx, yy);
                    b.step = a.step + 1;
                    mat[xx][yy] = b.step;
                    q.add(b);
                    vis[xx][yy] = true;
                }
            }
        }
        return mat;
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
