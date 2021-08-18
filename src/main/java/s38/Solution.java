package s38;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 14:49
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().countAndSay(30));
    }

    public String countAndSay(int n) {
        if (n == 1) return "1";
        StringBuilder s = new StringBuilder("1");
        for (int i = 2; i <= n; i++) {
            StringBuilder stringBuilder = new StringBuilder("");
            int len = s.length();
            int num = 1;
            for (int j = 1; j < len; j++) {
                if (s.charAt(j) != s.charAt(j - 1)) {
                    stringBuilder.append(num);
                    stringBuilder.append(s.charAt(j - 1));
                    num = 1;
                } else num++;
            }
            stringBuilder.append(num);
            stringBuilder.append(s.charAt(len - 1));
            s = stringBuilder;
        }
        return s.toString();
    }

}
