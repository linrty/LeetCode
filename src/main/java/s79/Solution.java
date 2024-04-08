package s79;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/11 19:56
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    boolean[][] vis;
    char[][] map;
    String words;
    int tx[] = {1,1,-1,-1};
    int ty[] = {1,-1,1,-1};
    public boolean exist(char[][] board, String word) {
        words = word;
        map = board;
        vis = new boolean[board.length+5][board[0].length+5];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == words.charAt(0)){
                    vis[i][j] = true;
                    if (dfs(i,j,1)) return true;
                    vis[i][j] = false;
                }
            }
        }
        return false;
    }

    public boolean dfs(int x,int y,int pos){
        System.out.println(pos);
        if (pos == words.length()) return true;
        for (int i = 0; i < 4; i++) {
            int xx = x + tx[i];
            int yy = y + ty[i];
            if (xx>=0&&xx<map.length&&yy>=0&&yy<map[0].length&&vis[xx][yy]==false&&map[xx][yy]==words.charAt(pos)){
                vis[xx][yy] = true;
                if (dfs(xx,yy,pos+1)) return true;
                vis[xx][yy] = false;
            }
        }
        return false;
    }
}
