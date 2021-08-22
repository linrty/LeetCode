package s345;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/19 18:28
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "";
        System.out.println(new Solution().reverseVowels(s));
    }

    public String reverseVowels(String s) {
        int sta = 0;
        int end = s.length() - 1;
        char[] str = s.toCharArray();
        while (sta < end) {
            if (isAEIOU(str[sta])) {
                while (end >= sta && !isAEIOU(str[end])) {
                    end--;
                }
                char ch = str[sta];
                str[sta] = str[end];
                str[end] = ch;
                sta++;
                end--;
                continue;
            }
            sta++;
        }
        return String.valueOf(str);
    }

    public boolean isAEIOU(char ch) {
        if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
            return true;
        }
        return false;
    }
}
