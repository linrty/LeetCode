package s70;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().climbStairs(3));
    }

    public int climbStairs(int n) {
        if (n < 3) return n;
        int pre1, pre2;
        pre1 = 1;
        pre2 = 2;
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            ans = pre1 + pre2;
            pre1 = pre2;
            pre2 = ans;
        }
        return ans;
    }
}
