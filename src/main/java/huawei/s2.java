package huawei;

import java.awt.color.ICC_ColorSpace;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class s2 {
    public static int[][] map;
    public static int n;
    public static int m;
    public static int[] tx = {1,0,-1,0};
    public static int[] ty = {0,1,0,-1};


    public static boolean[][] vis;
    public static int minCost;

    public static boolean flag;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        scanner.nextLine();
        minCost = Integer.MAX_VALUE;
        flag = false;
        map = new int[n][m];
        vis = new boolean[n][m];
        List<Integer>cx = new ArrayList<>();
        List<Integer>cy = new ArrayList<>();
        int sx,sy,ex,ey;
        sx = sy = ex = ey= 0;
        for (int i = 0; i < n; i++) {
            String s = scanner.nextLine();
            String[] strs = s.split(" ");
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].equals("S")){
                    sx = i;
                    sy = j;
                    map[i][j] = 0;
                } else if (strs[j].equals("B")) {
                    map[i][j] = -1;
                } else if (strs[j].equals("C")) {
                    map[i][j] = 0;
                    cx.add(i);
                    cy.add(j);
                } else if (strs[j].equals("E")) {
                    map[i][j] = 0;
                    ex = i;
                    ey = j;
                }else{
                    map[i][j] = Integer.valueOf(strs[j]);
                }
            }
        }
        for (int i = 0; i < cx.size(); i++) {
            vis[sx][sy] = true;
            int cost1 = dfs(sx,sy,cx.get(i),cy.get(i),0);
            vis[sx][sy] = false;
            vis[cx.get(i)][cy.get(i)] = true;
            int cost2 = dfs(cx.get(i),cy.get(i),ex, ey, 0);
            vis[cx.get(i)][cy.get(i)] = false;
            if (cost1 == -1 || cost2 == -1) continue;
            minCost = Math.min(cost2 + cost1, minCost);
        }
        if (minCost == Integer.MAX_VALUE){
            System.out.println(-1);
        }else{
            System.out.println(minCost);
        }
    }
    public static int dfs(int sx, int sy, int ex,int ey,int pre_cost){
        if (sx == ex && sy == ey){
            return pre_cost;
        }
        int cost = pre_cost + map[sx][sy];
        int min_item = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            if (sx + tx[i] >= 0 && sx + tx[i] <n
                    && sy + ty[i] >= 0 && sy + ty[i] < m
                    && !vis[sx+tx[i]][sy+ty[i]]
                    && map[sx+tx[i]][sy+ty[i]] != -1){
                vis[sx+tx[i]][sy+ty[i]] = true;
                min_item = Math.min(min_item, dfs(sx+tx[i], sy + ty[i],ex, ey, cost));
                vis[sx+tx[i]][sy+ty[i]] = false;
            }
        }
        return min_item == Integer.MAX_VALUE? -1: min_item;
    }
}
