package ali;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class s1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        int res1 = 0;
        int res2 = 0;
        for (int i = 0 ; i < m; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            x++;
            y++;
            if(x == 1){
                if (map.getOrDefault(1, -1) != -1){
                    map.put(x, y);
                    res1++;
                }
            }

        }
        System.out.println(res2 + " " + res1);
    }
    public static int gcd (int a,int b) {
        int c;
        while (b!=0) {
            c = a%b;
            a = b;
            b = c;
        }
        return a;
    }
}
