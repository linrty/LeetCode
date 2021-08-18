package s36;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/15 14:16
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public boolean isValidSudoku(char[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            set.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') continue;
                if (!set.contains((int) (board[i][j] - '0'))) {
                    set.add((int) (board[i][j] - '0'));
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            set.clear();
            for (int j = 0; j < board[i].length; j++) {
                if (board[j][i] == '.') continue;
                if (!set.contains((int) (board[j][i] - '0'))) {
                    set.add((int) (board[j][i] - '0'));
                } else {
                    return false;
                }
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                set.clear();
                for (int k = i * 3; k < (i + 1) * 3; k++) {
                    for (int l = j * 3; l < (j + 1) * 3; l++) {
                        if (board[k][l] == '.') continue;
                        if (!set.contains((int) (board[k][l] - '0'))) {
                            set.add((int) (board[k][l] - '0'));
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
