package s17;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> list = new ArrayList<>();
    int len = 0;
    String[] strings = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    String s = "";

    public static void main(String[] args) {
        String digits = "2";
        System.out.println(new Solution().letterCombinations(digits));
    }

    public List<String> letterCombinations(String digits) {
        s = digits;
        len = digits.length();
        if (len == 0) return list;
        else {
            dfs(0, new StringBuilder(""));
            return list;
        }
    }

    public void dfs(int pos, StringBuilder stringBuilder) {
        if (pos == len) {
            list.add(stringBuilder.toString());
            return;
        }
        int x = s.charAt(pos) - '0';
        for (int i = 0; i < strings[x].length(); i++) {
            dfs(pos + 1, new StringBuilder(stringBuilder.toString() + strings[x].charAt(i)));
        }
    }
}
