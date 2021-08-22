package s541;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/20 11:18
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "abcd";
        int k = 2;
        System.out.println(new Solution().reverseStr(s, k));
    }

    public String reverseStr(String s, int k) {
        int len = s.length();
        int num = len / k;
        if (len % k != 0) num++;
        int pos = 0;
        char[] str = s.toCharArray();
        while (pos < num) {
            int sta = pos * k;
            int end = sta + k - 1;
            if (end >= len) end = len - 1;
            if (pos % 2 == 0) {
                while (sta < end) {
                    char ch = str[sta];
                    str[sta] = str[end];
                    str[end] = ch;
                    sta++;
                    end--;
                }
            }
            pos++;
        }
        return String.valueOf(str);
    }
}
