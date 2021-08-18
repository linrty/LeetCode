package s58;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 12:08
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "luffy";
        System.out.println(new Solution().lengthOfLastWord(s));
    }

    public int lengthOfLastWord(String s) {
        int len = s.length() - 1;
        int num = 0;
        while (len >= 0) {
            if (s.charAt(len) != ' ') {
                while (len >= 0 && s.charAt(len) != ' ') {
                    len--;
                    num++;
                }
                return num;
            }
            len--;
        }
        return num;
    }
}
