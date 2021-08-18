package s14;

public class Solution {
    public static void main(String[] args) {
        String[] strs = {"ab", "a"};
        System.out.println(new Solution().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        StringBuilder stringBuilder = new StringBuilder();
        int len1 = strs[0].length();
        for (int i = 0; i < len1; i++) {
            boolean flag = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != strs[0].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            if (flag) stringBuilder.append(strs[0].charAt(i));
            else break;
        }
        return stringBuilder.toString();
    }
}
