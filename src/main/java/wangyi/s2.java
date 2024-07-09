package wangyi;

import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        for (long i = 1L; i <= 7L; i++) {
            long x = m / i;
            long z = n - x;
            if (z > 0){
                long y = m - x * i;
                long k = 0;
                if (z > y){
                    k = (z - y) / (i - 1L);
                    if ((z - y) % (i - 1L) != 0L) k++;
                }
                System.out.println(x - k);
            }else{
                long y = m - x * i;
                long k = 0;
                if (-z * i + y > 0){
                    k = (-z * i + y) / (7L - i);
                    if ( (-z * i + y) % (7L - i) != 0) k++;
                }
                if (n-k<0L) System.out.println(0);
                else System.out.println(n - k);
            }

        }
    }
}
