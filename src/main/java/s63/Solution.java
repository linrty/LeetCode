package s63;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 15:30
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length + 5][obstacleGrid[0].length + 5];
        dp[1][1] = 1;
        for (int i = 1; i < obstacleGrid.length; i++) {
            for (int j = 1; j < obstacleGrid[0].length; j++) {
                if ((i == 1 && j == 1) || obstacleGrid[i - 1][j - 1] == 1) continue;
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[obstacleGrid.length][obstacleGrid[0].length];
    }
}
