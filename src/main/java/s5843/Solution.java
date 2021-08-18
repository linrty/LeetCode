package s5843;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 19:50
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String[] patterns = {"a", "abc", "bc", "d"};
        String word = "abc";
        System.out.println(new Solution().numOfStrings(patterns, word));
    }

    public int numOfStrings(String[] patterns, String word) {
        int num = 0;
        for (int i = 0; i < patterns.length; i++) {
            String s = patterns[i];
            if (s.length() > word.length()) continue;
            for (int j = 0; j <= word.length() - s.length(); j++) {
                String str = word.substring(j, j + s.length());
                System.out.println(str);
                if (str.equals(s)) {
                    num++;
                    break;
                }
            }
        }
        return num;
    }
}
