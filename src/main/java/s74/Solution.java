package s74;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 16:16
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int staRow,endRow;
        int staCol,endCol;
        staRow = staCol = 0;
        endRow = matrix.length;
        endCol = matrix[0].length;
        while (staRow <= endRow){
            int mid = (staRow + endRow) / 2;
            if (target > matrix[mid][0]){
                staRow = mid + 1;
            }else if (target < matrix[mid][0]){
                endRow = mid - 1;
            }else{
                return true;
            }
        }
        int pos = 0;
        if (target>matrix[endRow][0]){
            pos = endRow;
        }else{
            pos = endRow - 1;
        }
        while (staCol <= endCol){
            int mid = (staCol + endCol) / 2;
            if (target > matrix[pos][mid]){
                staCol = mid + 1;
            }else if (target < matrix[pos][mid]){
                endCol = mid + 1;
            }else {
                return true;
            }
        }
        return false;
    }
}
