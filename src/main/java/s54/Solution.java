package s54;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 10:54
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(new Solution().spiralOrder(matrix));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        boolean[][] vis = new boolean[matrix.length + 5][matrix[0].length + 5];
        int x, y;
        List<Integer> list = new ArrayList<>();
        x = 0;
        y = 0;
        list.add(matrix[x][y]);
        vis[x][y] = true;
        while (true) {
            boolean flag = false;
            while (!vis[x][y + 1] && y + 1 < matrix[0].length) {
                y++;
                flag = true;
                vis[x][y] = true;
                list.add(matrix[x][y]);
            }
            while (!vis[x + 1][y] && x + 1 < matrix.length) {
                x++;
                flag = true;
                vis[x][y] = true;
                list.add(matrix[x][y]);
            }
            while (y - 1 >= 0 && !vis[x][y - 1]) {
                y--;
                flag = true;
                vis[x][y] = true;
                list.add(matrix[x][y]);
            }
            while (x - 1 >= 0 && !vis[x - 1][y]) {
                x--;
                flag = true;
                vis[x][y] = true;
                list.add(matrix[x][y]);
            }
            if (!flag) break;
        }
        return list;
    }

}
