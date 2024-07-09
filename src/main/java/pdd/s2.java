package pdd;

import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int[] a = new int[n];
            long MOD = 1000000007;
            for (int i = 0; i < n; i++) {
                a[i] = scanner.nextInt();
            }

            // 新增差
            long pre = 0L;
            long res = 0L;
            long pre_res = 0L;
            // 连续的不同数字的个数
            int nums = 0;
            for (int i = 1; i < n;i++){
                // 如果新的数字与前一个数字相同，那么没有新的分数增加
                if (a[i] != a[i-1]){
                    if (nums == 0){
                        // 前面没有可加的数组
                        pre = a[i-1];
                        nums = 2;
                        // 新增了一个符合条件的数组
                        pre_res = res;
                        res = (res + (pre + a[i])%MOD)%MOD;
                    }else{
                        pre = (res - pre_res + a[i-1] + MOD)%MOD;
                        pre_res = res;
                        res = (res + (pre + ((long)a[i] * nums)%MOD)%MOD)%MOD;
                        nums++;
                    }
                }else{
                    pre_res = res;
                    nums = 0;
                }
            }
            System.out.println(res);
        }
    }
}
