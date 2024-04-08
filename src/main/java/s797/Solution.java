package s797;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/25 9:32
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        boolean[][] vis = new boolean[50][50];
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                vis[i][graph[i][j]] = true;
            }
        }
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> a = new ArrayList<>();
        a.add(0);
        queue.add(a);
        List<List<Integer>> lists = new ArrayList<>();
        while (!queue.isEmpty()){
            List<Integer> list = queue.poll();
            int x = list.get(list.size()-1);
            if (x == graph.length-1){
                lists.add(list);
                continue;
            }
            for (int i = 0; i < graph[x].length; i++) {
                List<Integer> newList = new ArrayList<>(list);
                newList.add(graph[x][i]);
                queue.add(newList);
            }
        }
        return lists;
    }
}
