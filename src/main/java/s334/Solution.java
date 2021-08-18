package s334;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        char[] s = {};
        new Solution().reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public void reverseString(char[] s) {
        int sta = 0;
        int end = s.length - 1;
        while (sta < end) {
            char ch = s[sta];
            s[sta] = s[end];
            s[end] = ch;
            sta++;
            end--;
        }
    }
}
