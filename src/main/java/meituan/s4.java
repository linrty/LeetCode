package meituan;

import netscape.security.UserTarget;

import java.util.Arrays;
import java.util.Scanner;

public class s4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        // 记录数组，0~n-1部分从n-1下标开始记录1比2的数量多1，2，3，4.....个的区间数量
        // 同理n+1~2n+1部分表示2比1多1，2，3，4....的区间数量
        int[] vis = new int[ 2 * n + 1];
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        long res = 0L;
        // 1与2数量相同的位置index
        int pos = n;
        // 1比2数量多的区间数量总和
        int sum1 = 0;
        // 2比1数量多的区间数量总和
        int sum2 = 0;
        // 每次只处理新增加的区间
        for (int i = 0; i < n; i++) {
            if (a[i] == 1){
                // 新增加一个空的区间
                vis[pos]++;
                // 当前位置是1，所有区间都会加上一个1，所以。pos向左边移动一下
                // 移动的时候维护好sum1和sum2
                sum1 += vis[pos];
                pos++;
                sum2 -= vis[pos];
            }else{
                vis[pos]++;
                sum2 += vis[pos];
                pos--;
                sum1 -= vis[pos];
            }
            // sum2全是众数为2的区间数量，sum1全是众数为1的数量
            res += (sum2*2);
            res += sum1;
            // 1和2数量相同，认定1为众数
            res += vis[pos];
        }
        System.out.println(res);
    }
}
