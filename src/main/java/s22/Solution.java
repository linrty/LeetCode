package s22;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<String> list = new ArrayList<>();
    int len = 0;

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        len = 2 * n;
        getPos(0, 0, new StringBuilder(""));
        return list;
    }

    public void getPos(int pos, int num, StringBuilder stringBuilder) {
        if (pos == len && num == 0) {
            list.add(stringBuilder.toString());
            return;
        }
        if (pos == len || num < 0) return;
        getPos(pos + 1, num + 1, new StringBuilder(stringBuilder.toString() + '('));
        getPos(pos + 1, num - 1, new StringBuilder(stringBuilder.toString() + ')'));
    }

}
