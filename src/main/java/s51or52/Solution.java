package s51or52;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 21:40
 * @Version 1.0
 **/
public class Solution {
    char[][] s;
    boolean[][] vis;
    int len;
    int tx, ty;
    List<List<String>> lists = new ArrayList<>();

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(new Solution().totalNQueens(i));
        }
        System.out.println(new Solution().totalNQueens(9));
    }

    public int totalNQueens(int n) {
        len = n;
        s = new char[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = '.';
            }
        }
        dfs(0);
        return lists.size();
    }

    public List<List<String>> solveNQueens(int n) {
        len = n;
        s = new char[n][n];
        vis = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                s[i][j] = '.';
            }
        }
        dfs(0);
        return lists;
    }

    public void dfs(int pos) {
        if (pos == len) {
            List<String> stringList = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                StringBuilder str = new StringBuilder("");
                for (int j = 0; j < len; j++) {
                    if (s[i][j] == 'Q') vis[i][j] = true;
                    str.append(s[i][j]);
                }
                stringList.add(str.toString());
            }
            lists.add(stringList);
            return;
        }
        if (pos == 0) tx = ty = 0;
        for (int i = tx; i < len; i++) {
            for (int j = ty; j < len; j++) {
                ty = 0;
                if (pos == 0 && vis[i][j]) continue;
                if (check(i, j)) {
                    s[i][j] = 'Q';
                    tx = i;
                    ty = j;
                    dfs(pos + 1);
                    s[i][j] = '.';
                }
            }
        }


    }

    public boolean check(int x, int y) {
        for (int i = 0; i < len; i++) {
            if (s[i][y] == 'Q') return false;
        }
        for (int i = 0; i < len; i++) {
            if (s[x][i] == 'Q') return false;
        }

        int xx, yy;
        xx = x;
        yy = y;
        while (xx >= 0 && xx < len && yy >= 0 && yy < len) {
            if (xx == x) {
                xx--;
                yy++;
                continue;
            }
            if (s[xx][yy] == 'Q') return false;
            xx--;
            yy++;
        }
        xx = x;
        yy = y;
        while (xx >= 0 && xx < len && yy >= 0 && yy < len) {
            if (xx == x) {
                xx--;
                yy--;
                continue;
            }
            if (s[xx][yy] == 'Q') return false;
            xx--;
            yy--;
        }
        xx = x;
        yy = y;
        while (xx >= 0 && xx < len && yy >= 0 && yy < len) {
            if (xx == x) {
                xx++;
                yy++;
                continue;
            }
            if (s[xx][yy] == 'Q') return false;
            xx++;
            yy++;
        }
        xx = x;
        yy = y;
        while (xx >= 0 && xx < len && yy >= 0 && yy < len) {
            if (xx == x) {
                xx++;
                yy--;
                continue;
            }
            if (s[xx][yy] == 'Q') return false;
            xx++;
            yy--;
        }
        return true;
    }
}
