package meituan;

import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        if (x > -10 && x < 10){
            System.out.println(x);
            return;
        }
        long num1, num2;
        boolean flag = x >= 0L;
        if(x<0L) x = -x;
        long mod = 10L;
        long max_sum = Long.MIN_VALUE;
        while(x >= mod){
            num2 = x % mod;
            num1 = x / mod;
            if (!flag) num1 = -num1;
            max_sum = Math.max(num1 + num2, max_sum);
            mod*=10L;
        }
        System.out.println(max_sum);
    }
}
