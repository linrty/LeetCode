package m0102;

import java.lang.reflect.Array;

public class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        int[] num1 = new int[30];
        int[] num2 = new int[30];
        if (s1.length()!=s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            num1[s1.charAt(i)-'a']++;
            num2[s2.charAt(i)-'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (num1[i] != num2[i]) return false;
        }
        return true;
    }
}
