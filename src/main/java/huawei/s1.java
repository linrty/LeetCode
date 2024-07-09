package huawei;

import java.util.Scanner;

public class s1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        if(s1.length() == 0 || s2.length() == 0){
            System.out.println(-1);
            return;
        }
        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");
        int max_len = -1;
        int max_l = 0;
        int max_r = 0;
        for (int i = 0; i < str1.length; i++) {
            int j = 0;
            while(j < str2.length && !str1[i].equals(str2[j])) j++;
            if (j == str2.length) continue;
            int left = j;
            int ii = i;
            while(j < str2.length && ii < str1.length && str1[ii].equals(str2[j])){
                j++;
                ii++;
            }
            int right = j;
            if (right - left > max_len){
                max_len = right - left;
                max_l = left;
                max_r = right;
            }
        }
        if (max_len == -1){
            System.out.println(-1);
        }else{
            boolean flag = true;
            for (int i = max_l; i < max_r; i++) {
                if (flag){
                    flag = false;
                    System.out.print(str2[i]);
                }else{
                    System.out.print(" " + str2[i]);
                }
            }
        }
    }
}
