package wangyi;

import java.util.*;

public class s3 {
    public static StringBuilder[] strMap;
    public static int[] tx = {0,0,1,-1};
    public static int[] ty = {1,-1,0,0};
    public static int n,m,k;
    public static int[] xx;
    public static int[] yy;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();
        k = scanner.nextInt();
        scanner.nextLine();
        strMap = new StringBuilder[n];
        for (int i = 0; i < n; i++) {
            strMap[i] = new StringBuilder(scanner.nextLine());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (strMap[i].charAt(j) == 'T'){
                    setStrMap(i,j);
                }
            }
        }
        int sx,sy,ex,ey;
        sx = sy = ex = ey = -1;
        xx = new int[10];
        yy = new int[10];
        int pos = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (strMap[i].charAt(j) == 'S'){
                    sx = i;
                    sy = j;
                } else if (strMap[i].charAt(j) == 'E') {
                    ex = i;
                    ey = j;
                } else if (strMap[i].charAt(j) == '$') {
                    xx[pos] = i;
                    yy[pos] = j;
                    pos++;
                }
            }
        }
        if (sx == -1 || ex == -1) {
            System.out.println(-1);
            return;
        }
        xx[pos] = sx;
        yy[pos] = sy;
        pos++;
        xx[pos] = ex;
        yy[pos] = ey;
        pos++;
        int[][] edg = new int[10][10];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) edg[i][j] = 0;
                else{
                    edg[i][j] = bfs(xx[i], yy[i], xx[j], yy[j]);
                }
            }
        }
        System.out.println();


    }

    public static void setStrMap(int x, int y){
        boolean[][] vis = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(x,y,0);
        vis[x][y] = true;
        q.add(p);
        while (!q.isEmpty()){
            p = q.poll();
            if (p.p == k) continue;
            for (int i = 0; i < 4; i++) {
                if (p.x + tx[i] >= 0 && p.x + tx[i] < n
                        && p.y + ty[i] >= 0 && p.y + ty[i] < m
                        && !vis[p.x+tx[i]][p.y+ty[i]]
                        && strMap[p.x+tx[i]].charAt(p.y+ty[i]) != 'T'){
                    vis[p.x+tx[i]][p.y+ty[i]] = true;
                    Point pp = new Point(p.x + tx[i], p.y + ty[i], p.p + 1);
                    q.add(pp);
                    strMap[p.x+tx[i]].setCharAt(p.y+ty[i],'#');
                }
            }
        }
    }

    public static int bfs(int x1,int y1,int x2,int y2){
        boolean[][] vis = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();
        Point p = new Point(x1,y1,0);
        while (!q.isEmpty()){
            p = q.poll();
            if (p.x == x2 && p.y == y2){
                return p.p;
            }
            for (int i = 0; i < 4; i++) {
                if (p.x + tx[i] >= 0 && p.x + tx[i] < n
                        && p.y + ty[i] >= 0 && p.y + ty[i] < m
                        && !vis[p.x+tx[i]][p.y+ty[i]]
                        && strMap[p.x+tx[i]].charAt(p.y+ty[i]) != 'T'
                        && strMap[p.x+tx[i]].charAt(p.y+ty[i]) != '#'){
                    vis[p.x+tx[i]][p.y+ty[i]] = true;
                    Point pp = new Point(p.x + tx[i], p.y + ty[i], p.p + 1);
                    q.add(pp);
                }
            }
        }
        return -1;
    }
}

class Point{
    public int x;
    public int y;
    public int p;
    public int num;
    public Point(int x,int y,int p){
        this.x = x;
        this.y = y;
        this.p = p;
    }
}
