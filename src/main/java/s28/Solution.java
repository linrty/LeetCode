package s28;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/14 14:43
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        String haystack = "";
        String needle = "";
        System.out.println(new Solution().strStr(haystack, needle));
    }

    public int strStr(String haystack, String needle) {
        int[] next = new int[needle.length() + 5];
        getNext(next, needle);
        int i, j;
        i = j = 0;
        int len1 = haystack.length();
        int len2 = needle.length();
        while (i < len1 && j < len2) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else j = next[j];
        }
        if (j == len2) return i - j;
        else return -1;
    }

    public void getNext(int[] next, String s) {
        int i, j;
        j = -1;
        i = 0;
        int len = s.length();
        next[0] = -1;
        while (i < len) {
            if (j == -1 || s.charAt(j) == s.charAt(i)) {
                i++;
                j++;
                if (i < len && s.charAt(i) == s.charAt(j)) next[i] = next[j];
                else next[i] = j;
            } else {
                j = next[j];
            }
        }
    }
}
