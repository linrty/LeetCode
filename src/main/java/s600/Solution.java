package s600;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 9:23
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Solution().findIntegers(n));
    }

    public int findIntegers(int n) {
        int[][] dp = new int[50][2];
        dp[1][0] = 1;
        dp[1][1] = 1;
        for (int i = 2; i <= 32; i++) {
            dp[i][1] = dp[i-1][0];
            dp[i][0] = dp[i-1][0] + dp[i-1][1];
        }
        int[] num = new int[50];
        int pos = 1;
        while (n!=0){
            num[pos++] = n % 2;
            n/=2;
        }
        pos--;

        int sum = 0;
        while (pos>0){
            if(num[pos] == 1){
                sum+=dp[pos][0];
                if (num[pos+1] == 1) break;
            }
            pos--;
        }
        if (pos == 0){
            sum++;
        }
        return sum;
    }
}
