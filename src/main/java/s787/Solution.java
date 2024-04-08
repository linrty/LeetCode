package s787;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/24 18:41
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }


    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[][] ans = new int[n+5][n+5];
        for (int i = 0; i < ans.length; i++) {
            Arrays.fill(ans[i],-1);
        }
        for (int i = 0; i < flights.length; i++) {
            ans[flights[i][0]][flights[i][1]] = flights[i][2];
        }
        int[][] dp = new int[n+5][k+5];
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i],-1);
        }
        dp[src][0] = 0;
        int mini = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (ans[src][i]!=-1){
                dp[i][0] = ans[src][i];
                if (i == dst) mini = Math.min(mini,dp[i][0]);
            }
        }
        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                for (int l = 0; l < n; l++) {
                    if (dp[l][i-1]==-1 || ans[l][j]==-1) continue;
                    if (dp[j][i] == -1) dp[j][i] = dp[l][i-1] + ans[l][j];
                    else dp[j][i] = Math.min(dp[j][i],dp[l][i-1] + ans[l][j]);
                }
                if (j == dst){
                    if (dp[j][i]!=-1){
                        mini = Math.min(mini,dp[j][i]);
                    }
                }
            }
        }
        if (mini == Integer.MAX_VALUE) return -1;
        else return mini;
    }
}
