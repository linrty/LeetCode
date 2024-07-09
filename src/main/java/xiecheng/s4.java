package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class s4 {
    public static int n=0, d=0;
    public static int[] dp;
    public static int[] child;
    public static List<Integer>[] E;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        dp = new int[n];
        child = new int[n];
        E = new List[n];
        for (int i = 0; i < n; i++) {
            E[i] = new ArrayList<>();
        }
        for (int i = 0 ; i < n-1; i++){
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            E[u].add(v);
            E[v].add(u);
        }
        dfs(1, 0);

    }

    public static void dfs(int u, int fa){
        for (int v: E[u]){
            if (v == fa) continue;
            dfs(v, u);
            d = Math.max(d, dp[v] + dp[u] + 1);
            if (dp[v] + 1 > dp[u]){
                dp[u] = dp[v] + 1;
                child[u] = v;
            }
        }
    }
}
