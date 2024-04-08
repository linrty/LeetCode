package s2596;

public class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if(grid[0][0]!=0) return false;
        int[] tx = {1,1,-1,-1,2,2,-2,-2};
        int[] ty = {2,-2,2,-2,1,-1,1,-1};
        int len = grid.length;
        for (int i = 0;i < len;i++){
            for (int j = 0;j < len;j++){
                if (grid[i][j] == 0) continue;
                boolean flag = false;
                for (int k = 0;k < 8;k++){
                    int x = i + tx[k];
                    int y = j + ty[k];
                    if (x >= 0 && x < len && y >= 0 && y < len && grid[x][y] + 1 == grid[i][j]){
                        flag = true;
                        break;
                    }
                }
                if (!flag) return false;
            }
        }
        return true;
    }
}
