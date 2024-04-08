package s264;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/24 19:17
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().nthUglyNumber(1690));
    }
    public int nthUglyNumber(int n) {

        PriorityQueue<Long> queue = new PriorityQueue<Long>();
        for (int i = 1; i <=5 ; i++) {
            queue.add((long) i);
        }
        int num = 0;
        while (!queue.isEmpty()){
            long x = queue.poll();
            num ++;
            if (num == n) return (int)x;
            if (!queue.contains(x*2)) queue.add(x*2);
            if (!queue.contains(x*3)) queue.add(x*3);
            if (!queue.contains(x*5)) queue.add(x*5);
        }
        return 0;
    }
}
