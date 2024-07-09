package wangyi;

import java.util.Scanner;

public class s1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] names = {"atk","atkper","def","spd"};
        int[] values = {0,0,0,0};
        for (int i = 0; i < 6; i++) {
            String str1 = scanner.nextLine();
            String[] str1s = str1.split(" ");
            for (int j = 0; j < names.length; j++) {
                if (names[j].equals(str1s[0])){
                    values[j] += Integer.valueOf(str1s[1]);
                }
            }
            int c = scanner.nextInt();
            scanner.nextLine();
            for (int j = 0; j < c; j++) {
                String str2 = scanner.nextLine();
                String[] str2s = str2.split(" ");
                for (int k = 0; k < names.length; k++) {
                    if( names[k].equals(str2s[0])){
                        values[k] += Integer.valueOf(str2s[1]);
                    }
                }
            }
            if (i != 5) scanner.nextLine();
        }
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i] + " " + values[i]);
        }
    }
}
