package s2034;

import javafx.scene.layout.Priority;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
}


class StockPrice {


    int cur_val;
    int cur_time;

    Queue<Pair> max_queue;
    Queue<Pair> min_queue;
    Map<Integer,Integer> map;
    public StockPrice() {
        cur_val = 0;
        cur_time = 0;
        map = new HashMap<>();
        max_queue = new PriorityQueue<>((o1, o2) -> o2.val - o1.val);
        min_queue = new PriorityQueue<>((o1, o2) -> o1.val - o2.val);
    }

    public void update(int timestamp, int price) {
        if (timestamp > cur_time){
            cur_time = timestamp;
            cur_val = price;
        }
        if (timestamp == cur_time){
            cur_val = price;
        }
        max_queue.add(new Pair(price, timestamp));
        min_queue.add(new Pair(price, timestamp));
        map.put(timestamp, price);
    }

    public int current() {
        return cur_val;
    }

    public int maximum() {
        while(true){
            Pair pair = max_queue.peek();
            if (map.get(pair.time) == pair.val){
                return pair.val;
            }else {
                max_queue.poll();
            }
        }
    }

    public int minimum() {
        while(true){
            Pair pair = min_queue.peek();
            if (map.get(pair.time) == pair.val){
                return pair.val;
            }else {
                min_queue.poll();
            }
        }
    }
}

class Pair{
    int val;
    int time;
    public Pair(int val, int time){
        this.val = val;
        this.time = time;
    }
}
