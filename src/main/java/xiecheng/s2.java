package xiecheng;

import java.util.Arrays;
import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a,b,c,d;
        a = new int[n];
        b = new int[n];
        c = new int[n];
        d = new int[n];
        for (int i = 0; i< n; i++)  a[i] = scanner.nextInt();
        for (int i = 0; i< n; i++)  b[i] = scanner.nextInt();
        for (int i = 0; i< n; i++) {
            d[i] = a[i] + b[i];
            c[i] = scanner.nextInt();
        }
        Arrays.sort(d);
        Arrays.sort(c);
        int p,q;
        p = q = 0;
        int res = 0;
        while(p < n && q < n){
            while(q < n &&d[p] > c[q]) q++;
            if (q == n) break;
            if (d[p] == c[q]) {
                res++;
                p++;
                q++;
            }else{
                p++;
            }
        }
        System.out.println(res);

    }
}
