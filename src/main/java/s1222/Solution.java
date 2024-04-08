package s1222;

import java.util.*;

public class Solution {
    class Point{
        int x;
        int y;
        int to;
        Point(int x,int y,int to){
            this.x = x;
            this.y = y;
            this.to = to;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }

        public int getTo() {
            return to;
        }

        public void setTo(int to) {
            this.to = to;
        }
    }
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        int[][] vis = new int[8][8];
        int[] tx = {0,0,1,-1,1,1,-1,-1};
        int[] ty = {1,-1,0,0,1,-1,1,-1};
        for (int[] queen : queens) {
            vis[queen[0]][queen[1]] = 1;
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<8;i++){
            int x = king[0];
            int y = king[1];
            while(x>=0&&x<8&&y>=0&&y<8){
                if(vis[x][y]==1){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(x);
                    tmp.add(y);
                    ans.add(tmp);
                    break;
                }
                x+=tx[i];
                y+=ty[i];
            }
        }
        return ans;
    }
}
