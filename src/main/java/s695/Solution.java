package s695;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 15:58
 * @Version 1.0
 **/
public class Solution {
    boolean[][] vis;
    int[][] nums;
    int[] tx = {0, 0, 1, -1};
    int[] ty = {1, -1, 0, 0};

    public static void main(String[] args) {

    }

    public int maxAreaOfIsland(int[][] grid) {
        vis = new boolean[grid.length][grid[0].length];
        nums = grid;
        int maxi = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    vis[i][j] = true;
                    int num = dfs(i, j);
                    maxi = Math.max(maxi, num);
                }
            }
        }
        return maxi;
    }

    public int dfs(int x, int y) {
        int size = 0;
        for (int i = 0; i < 4; i++) {
            int xx = x + tx[i];
            int yy = y + ty[i];
            if (xx >= 0 && xx < vis.length && yy >= 0 && yy < vis[0].length && !vis[xx][yy] && nums[xx][yy] == 1) {
                vis[xx][yy] = true;
                size += dfs(xx, yy);
            }
        }
        System.out.println(size);
        return size + 1;
    }
}
