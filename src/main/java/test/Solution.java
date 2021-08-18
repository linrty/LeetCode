package test;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countLargestGroup(13));
    }

    public int countLargestGroup(int n) {
        int[] ans = new int[50];

        int maxi = 0;
        int num = 0;
        Arrays.fill(ans, 0);
        for (int i = 1; i <= n; i++) {
            int j = i;
            int sum = 0;
            while (j != 0) {
                sum += (j % 10);
                j /= 10;
            }
            ans[sum]++;
        }
        for (int i = 1; i <= 36; i++) {
            if (ans[i] > maxi) {
                num = 1;
                maxi = ans[i];
            } else if (ans[i] == maxi) num++;
        }
        return num;
    }

}
