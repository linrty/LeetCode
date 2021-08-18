package s43;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 15:32
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "456453838555555555555555555555555555555555555555555555555555534343537834534";
        System.out.println(new Solution().multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        StringBuilder s1 = new StringBuilder(num1);
        StringBuilder s2 = new StringBuilder(num2);
        StringBuilder ans = new StringBuilder("");
        s1.reverse();
        s2.reverse();
        int len1 = s1.length();
        int len2 = s2.length();
        for (int i = 0; i < len1; i++) {
            int pos = i;
            int n1 = s1.charAt(i) - '0';
            for (int j = 0; j < len2; j++) {
                pos = i + j;
                int n2 = s2.charAt(j) - '0';
                int num = n1 * n2;
                do {
                    int t = num % 10;
                    num /= 10;
                    if (pos < ans.length()) {
                        num += ((t + ans.charAt(pos) - '0') / 10);
                        t = (t + ans.charAt(pos) - '0') % 10;
                        ans.replace(pos, pos + 1, Integer.toString(t));
                    } else {
                        ans.append(t);
                    }
                    pos++;
                } while (num != 0);
            }
        }
        int len = ans.length();
        for (int i = len - 1; i >= 0; i--) {
            if (ans.charAt(i) != '0') break;
            else {
                ans.deleteCharAt(i);
            }
        }
        if (ans.length() == 0) return "0";
        return ans.reverse().toString();
    }
}
