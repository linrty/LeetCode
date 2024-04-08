package s502;

import org.omg.PortableServer.POA;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/9/8 8:39
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }



    public class Point{
        public int v;
        public int w;

        public Point(int v, int w) {
            this.v = v;
            this.w = w;
        }

        public Point() {
        }

    }

    /**
     * @description: 与01背包问题不同，这种问题会改变背包的容量大小，所以可以每次手上的启动资金都会进行改变，所以可以选择力所能及的项目，先进行完成，获得资金后再启动其他项目
     * @author Linrty
     * @date 2021/9/8 8:42
     * @version 1.0
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        // profits 表示的是每个项目的纯利润
        // capital 表示每个项目的启动资金
        // 先需要进行处理将数据进行整合化，或者重写排序函数，将两个数组进行同时的排序
        Point[] ans = new Point[profits.length + 5];
        boolean[] vis = new boolean[profits.length + 5];
        for (int i = 0; i < profits.length; i++) {
            ans[i] = new Point();
            ans[i].v = profits[i];
            ans[i].w = capital[i];
        }

        int sum = 0;
        for (int i = 0; i < k; i++) {
            PriorityQueue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>() {
                @Override
                public int compare(Point o1, Point o2) {
                    if (o1.w == o2.w){
                        return o2.v - o1.v;
                    }
                    return o2.w - o1.w;
                }
            });
            int flag = 0;
            for (int j = 0; j < profits.length; j++) {
                if (!vis[j]&&ans[j].w<=w){
                    queue.add(ans[j]);
                    flag = j;
                }
            }

            if (!queue.isEmpty()){
                w = w + queue.poll().v;
                vis[flag] = true;
            }else {
                break;
            }
        }

        return w;
    }
}
