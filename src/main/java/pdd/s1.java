package pdd;

import java.util.Scanner;

public class s1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 分3种情况
        // 长度%3==0 ，确定的值，直接计算代价和分数即可
        // %3==1 ，有一个字符可以随便
        // %3==2 ，有两个字符可以随便
        int n = scanner.nextInt();
        String s = scanner.next();
        System.out.print(n/3);
        if( n % 3 == 0){
            // 分数可以直接算
            int res = 0;
            for (int i = 0; i < n; i += 3){
                res += s.charAt(i) - 'P';
                res += s.charAt(i) - 'D';
                res += s.charAt(i) - 'D';
            }
            System.out.println(" " + res);
        }else{
            int[][] pre_cost = new int[n][3];
            int[][] last_cost = new int[n][3];
            int[][] cost = new int[n][2];
            for (int i = 0 ; i < n; i++){
                cost[i][0] = s.charAt(i) - 'P';
                cost[i][1] = s.charAt(i) - 'D';
            }
        }
    }
}
