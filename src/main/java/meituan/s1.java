package meituan;

import java.util.Scanner;

public class s1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n][m];
        for (int i = 0 ; i < n; i++){
            for (int j = 0 ; j < m; j++){
                a[i][j] = in.nextInt();
            }
        }
        int res = 0;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (a[i][j] == a[i-1][j-1] && a[i][j] == a[i-1][j] && a[i][j] == a[i][j-1]) res++;
            }
        }
        System.out.println(res);
    }
}
