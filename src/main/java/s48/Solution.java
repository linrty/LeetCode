package s48;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/16 21:23
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public void rotate(int[][] matrix) {
        int x, y;
        x = matrix.length;
        for (int i = 0; i < x; i++) {
            int sta = 0;
            int end = x;
            while (sta < end) {
                int t = matrix[sta][x];
                matrix[sta][x] = matrix[end][x];
                matrix[end][x] = t;
                sta++;
                end--;
            }
        }

        for (int i = 1; i < x - 1; i++) {
            int lx, ly, rx, ry;
            lx = i;
            ly = 0;
            rx = 0;
            ry = i;
            while (lx > ly) {
                int t = matrix[lx][ly];
                matrix[lx][ly] = matrix[rx][ry];
                matrix[rx][ry] = t;
                lx--;
                ly++;
                rx++;
                ry--;
            }
        }
    }
}
