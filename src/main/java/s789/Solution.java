package s789;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/22 14:56
 * @Version 1.0
 **/
public class Solution {
    public static final int BASE = 10000;

    public static void main(String[] args) {

    }

    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int steps = Math.abs(target[0]) + Math.abs(target[1]);
        for (int i = 0; i < ghosts.length; i++) {
            int nums = Math.abs(ghosts[i][0] - target[0]) + Math.abs(ghosts[i][1] - target[1]);
            if (nums <= steps) return false;
        }
        return true;
    }

    class Point {
        int x, y;
        int step;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.step = step;
        }

        public Point() {
        }
    }
}
