package s733;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 21:48
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int[] tx = {1, -1, 0, 0};
        int[] ty = {0, 0, 1, -1};
        boolean[][] vis = new boolean[image.length][image[0].length];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(sr, sc));
        vis[sr][sc] = true;
        int num = image[sr][sc];
        image[sr][sc] = newColor;
        while (!queue.isEmpty()) {
            Point a = queue.poll();
            for (int i = 0; i < 4; i++) {
                Point b = new Point();
                if (a.x + tx[i] >= 0 && a.x + tx[i] < image.length && a.y + ty[i] >= 0 && a.y + ty[i] < image[0].length) {
                    if (!vis[a.x + tx[i]][a.y + ty[i]] && image[a.x + tx[i]][a.y + ty[i]] == num) {
                        vis[a.x + tx[i]][a.y + ty[i]] = true;
                        image[a.x + tx[i]][a.y + ty[i]] = newColor;
                        queue.add(new Point(a.x + tx[i], a.y + ty[i]));
                    }
                }
            }
        }
        return image;
    }

    public class Point {
        int x, y;

        public Point() {
        }

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
