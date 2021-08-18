package s67;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 21:22
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String a = "1010";
        String b = "1011";
        System.out.println(new Solution().addBinary(a, b));
    }

    public String addBinary(String a, String b) {
        StringBuilder s1 = new StringBuilder(a);
        StringBuilder s2 = new StringBuilder(b);
        s1.reverse();
        s2.reverse();
        int len1 = s1.length();
        int len2 = s2.length();
        StringBuilder str = new StringBuilder();
        int pre = 0;
        int i, j;
        i = j = 0;
        while (i < len1 && j < len2) {
            int num = s1.charAt(i) - '0' + s2.charAt(j) - '0' + pre;
            str.append(num % 2);
            pre = num / 2;
            i++;
            j++;
        }
        while (i < len1) {
            int num = s1.charAt(i) - '0' + pre;
            str.append(num % 2);
            pre = num / 2;
            i++;
        }
        while (j < len2) {
            int num = s2.charAt(j) - '0' + pre;
            str.append(num % 2);
            pre = num / 2;
            j++;
        }
        if (pre != 0) str.append(pre);
        return str.reverse().toString();
    }
}
