package s20;

public class Solution {
    public static void main(String[] args) {
        String s = "([]";
        System.out.println(new Solution().isValid(s));
    }

    public boolean isValid(String s) {
        int len = s.length();
        for (int i = 0; i < len; ) {
            int x;
            if (s.charAt(i) == '(') {
                x = check(i + 1, ')', s);
            } else if (s.charAt(i) == '{') {
                x = check(i + 1, '}', s);
            } else if (s.charAt(i) == '[') {
                x = check(i + 1, ']', s);
            } else {
                return false;
            }
            if (x == -1) return false;
            else i = x;
        }
        return true;
    }

    public int check(int sta, char endChar, String s) {
        if (sta >= s.length()) return -1;
        int x;
        for (int i = sta; i < s.length(); ) {
            if (s.charAt(i) == '(') {
                x = check(i + 1, ')', s);
            } else if (s.charAt(i) == '{') {
                x = check(i + 1, '}', s);
            } else if (s.charAt(i) == '[') {
                x = check(i + 1, ']', s);
            } else if (s.charAt(i) == endChar) {
                return i + 1;
            } else return -1;
            if (x == -1) return -1;
            else {
                i = x;
            }
        }
        return -1;
    }
}
