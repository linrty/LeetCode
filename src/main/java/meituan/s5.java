package meituan;

import javafx.scene.SubScene;

import java.math.BigInteger;
import java.util.Scanner;

public class s5 {
    public static final int MOD = 1000000007;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();
        System.out.println(solve(n, m, x1, y1, x2, y2));
    }
    public static int solve(int n, int m, int x1, int y1, int x2, int y2){
        BigInteger[][] dp1 = new BigInteger[n + 1][m + 1];
        BigInteger[][] dp2 = new BigInteger[n + 1][m + 1];

        dp1[x1][y1] = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ways = (i == 1 || j == 1 || i == n || j == m)? 2 : 3;
                BigInteger totalWays = BigInteger.valueOf(ways);
                if (i > 1) dp1[i][j] = dp1[i][j].add(dp1[i-1][j]);
                if (j > 1) dp1[i][j] = dp1[i][j].add(dp1[i][j-1]);
                if (i > 1 && j > 1) dp1[i][j] = dp1[i][j].add(dp1[i-1][j-1]);
                if (dp1[i][j].compareTo(BigInteger.ZERO) > 0) dp1[i][j] = dp1[i][j].divide(totalWays).mod(BigInteger.valueOf(MOD));
            }
        }

        dp2[x2][y2] = BigInteger.ONE;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int ways = (i == 1 || j == 1 || i == n || j == m)? 2 : 3;
                BigInteger totalWays = BigInteger.valueOf(ways);
                if (i > 1) dp2[i][j] = dp2[i][j].add(dp2[i-1][j]);
                if (j > 1) dp2[i][j] = dp2[i][j].add(dp2[i][j-1]);
                if (i > 1 && j > 1) dp2[i][j] = dp2[i][j].add(dp2[i-1][j-1]);
                if (dp2[i][j].compareTo(BigInteger.ZERO) > 0) dp2[i][j] = dp2[i][j].divide(totalWays).mod(BigInteger.valueOf(MOD));
            }
        }

        BigInteger res = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res = res.add(dp1[i][j].multiply(dp2[i][j])).mod(BigInteger.valueOf(MOD));
            }
        }
        return res.intValue();
    }
}
