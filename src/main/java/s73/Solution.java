package s73;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 15:36
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public void setZeroes(int[][] matrix) {
        boolean firstRow,firstCol;
        firstCol = firstRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0){
                    if (i == 0 && j == 0){
                        firstCol = firstRow = true;
                    }else if (i == 0){
                        firstRow = true;
                    }else if (j == 0){
                        firstCol = true;
                    }else{
                        matrix[i][0] = matrix[0][j] = 0;
                    }
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            if(matrix[i][0] == 0) {
                for (int j = 1; j < matrix[0].length; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < matrix[0].length; i++) {
            if (matrix[0][i] == 0){
                for (int j = 1; j < matrix.length; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (firstRow){
            for (int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol){
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
