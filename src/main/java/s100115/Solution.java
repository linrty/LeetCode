package s100115;

public class Solution {
    public int findChampion(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        for (int i = 0;i<n;i++){
            int flag = 0;
            for (int j = 0;j<m;j++){
                if (i == j) continue;
                if (grid[i][j] != 0) {
                    flag = 1;
                    break;
                }
            }
            if (flag == 0){
                return i;
            }
        }
        return -1;
    }
}
