package pdd;

import java.util.Arrays;
import java.util.Scanner;

public class s3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while (T-- > 0) {
            int n = scanner.nextInt();
            int[] a = new int[n];
            int[] pre = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
                if (i == 0) pre[i] = a[i];
                else pre[i] = a[i] + pre[i - 1];
            }
            //等差
            int sub = 0;
            // 厚度
            int min_height = a.length;
            // 和
            int min_sum = pre[n - 1];
            for (int i = 0; i < n -1; i++) {
                // 枚举所有等差情况
                sub = pre[i];
                int cur_num = sub;
                int next_num = sub + sub;
                int pos = i;
                int height = i + 1;
                int pre_pos = -1;
                do {
                    pre_pos = pos;
                    pos = Arrays.binarySearch(pre, next_num);
                    next_num += sub;
                    if (pos > 0) {
                        height = Math.max(height, pos - pre_pos);
                    }
                } while (pos > 0 && pos != n - 1);
                if (pos == n - 1) {
                    // 符合条件可以划分成功
                    if (height < min_height) {
                        min_height = height;
                        min_sum = sub;
                    } else if (height == min_height) {
                        min_sum = Math.min(min_sum, sub);
                    }
                }
            }
            System.out.println(min_height + " " + min_sum);
        }
    }
}
