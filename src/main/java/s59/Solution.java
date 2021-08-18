package s59;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 12:13
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int x = 0;
        int y = 0;
        int num = 1;
        ans[0][0] = num;
        num++;
        while (true) {
            boolean flag = false;
            while (y + 1 < n && ans[x][y + 1] == 0) {
                flag = true;
                y++;
                ans[x][y] = num;
                num++;
            }
            while (x + 1 < n && ans[x + 1][y] == 0) {
                flag = true;
                x++;
                ans[x][y] = num;
                num++;
            }
            while (y - 1 >= 0 && ans[x][y - 1] == 0) {
                flag = true;
                y--;
                ans[x][y] = num;
                num++;
            }
            while (x - 1 >= 0 && ans[x - 1][y] == 0) {
                flag = true;
                x--;
                ans[x][y] = num;
                num++;
            }
            if (!flag) break;
        }
        return ans;
    }
}
