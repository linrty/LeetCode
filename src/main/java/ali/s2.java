package ali;

import java.util.PriorityQueue;
import java.util.Scanner;

public class s2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        while(T-- > 0){
            int n = scanner.nextInt();
            int sum = 0;
            int num = n;
            while(num > 0){
                sum += num%10;
                num /= 10;
            }
            if (n%sum == 0) System.out.println("1");
            else System.out.println("2");
        }
    }
}
