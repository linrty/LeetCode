package s746;

public class Solution {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(new Solution().minCostClimbingStairs(cost));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        for (int i = 2; i <= n; i++) {
            if (i == n) {
                return Math.min(cost[i - 1], cost[i - 2]);
            }
            cost[i] += Math.min(cost[i - 1], cost[i - 2]);
        }
        return 0;
    }
}
