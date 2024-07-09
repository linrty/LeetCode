package meituan;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class s3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        while(q-- > 0){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine();
            String s = scanner.nextLine();
            String t = scanner.nextLine();
            int len = 0;
            for (int i = 0; i < n; i++) {
                char s_ch = s.charAt(i);
                char t_ch = t.charAt(i);
                int l = 0;
                if (s_ch > t_ch) l = t_ch - 'a' + 'z' - s_ch + 1;
                else l = t_ch - s_ch;
                len += l;
            }
            System.out.println(len);
            if (k < len){
                System.out.println("No");
            }else{
                if ((len - k) % 26 == 0){
                    System.out.println("Yes");
                }else{
                    System.out.println("No");
                }
            }
        }
    }
}
