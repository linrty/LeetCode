package s551;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 11:48
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String s = "PPALLL";
        System.out.println(new Solution().checkRecord(s));
    }

    public boolean checkRecord(String s) {

        int a = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == 'A') {
                a++;
                if (a >= 2) return false;
            } else if (s.charAt(i) == 'L') {
                if (i > 1) {
                    if (s.charAt(i - 1) == 'L' && s.charAt(i - 2) == 'L') return false;
                }
            }
        }
        return true;
    }
}
