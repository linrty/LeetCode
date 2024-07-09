package xiecheng;

import java.util.Scanner;

public class s3 {
    public static void main(String[] args) {
        // 欧拉筛素数
        boolean[] vis =  new boolean[1000005];
        vis[0] = vis[1] = true;
        int[] prime = new int[1000005];
        int k = 0;
        for (int i = 2; i <= 1000000; i ++ ){
            if (!vis[i]) prime[k++] = i;
            for (int j = 0 ; j < k && i*prime[j]<=1000000; j++){
                vis[i*prime[j]] = true;
                if (i%prime[j] == 0){
                    break;
                }
            }
        }
        // 两个都不是2的素数相加一定等于合数，所以只有遇到2的时候需要特殊判定
        // 除了 2 2 3可以连接合并两次，其他都不可以合并两次，因为素数只在6二点两边，而2和一个素数还是素数的条件是另一个数必须%6==5，而2 2 x
        // 是素数的条件是x必须在%6==1
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        // 备用数组
        int[] b = new int[n];
        // 用于存放%6为5的素数
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        // 先合并 2 2 3
        int pos = 0;
        for (int i = 0; i < n; ) {
            if( i < n-2 && (a[i] == 2 && a[i+1] == 2 && a[i+2] == 3
                || a[i] == 2 && a[i+1] == 3 && a[i+2] == 2
                || a[i] == 3 && a[i+1] == 2 && a[i+2] == 2) ){
                b[pos++] = 7;
                i+=3;
            }else{
                b[pos++] = a[i++];
            }
        }
        int pos1 = 0;
        // 找到有2的位置
        for (int i = 0 ; i < pos;){
            if (b[i] == 2){
                if (i < pos-1 && !vis[b[i+1]+2]){
                    b[i+1] = b[i+1] + 2;
                    i++;
                    continue;
                }
                if (i > 0 && !vis[b[i-1]+2]){
                    a[pos1-1] = a[pos1-1] + 2;
                    i++;
                    continue;
                }
                a[pos1++] = b[i++];
            }else{
                a[pos1++] = b[i++];
            }
        }
        pos = 0;
        // 正常合并
        for (int i = 0 ; i< pos1;){
            if (i< pos1-1 && !vis[a[i]] && !vis[a[i+1]]){
                b[pos++] = a[i] + a[i+1];
                i+=2;
            }else{
                b[pos++] = a[i++];
            }
        }

        System.out.println(pos);
    }
}
