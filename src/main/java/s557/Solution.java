package s557;

public class Solution {
    public static void main(String[] args) {
        String s = "123";
        System.out.println(new Solution().reverseWords(s));
    }

    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        int sta = 0;
        int len = s.length();
        while (i <= len) {
            if (i == len || s.charAt(i) == ' ') {
                StringBuilder str = new StringBuilder(s.substring(sta, i));
                sta = i + 1;
                str.reverse();
                stringBuilder.append(str);
                if (sta < len - 1) stringBuilder.append(' ');
            }
            i++;
        }
        return stringBuilder.toString();
    }

}
