package s1155;

public class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int mod = 1000000007;
        int [][]dp = new int[n+1][target+1];
        dp[0][0] = 0;
        for (int i = 1;i<=n;i++){
            for (int j = 1;j<=target;j++){
                for (int p = 1;p<=k;p++){
                    if (j-p>=0){
                        dp[i][j] = (dp[i][j] + dp[i-1][j-p]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
