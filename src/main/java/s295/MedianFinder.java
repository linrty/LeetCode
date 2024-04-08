package s295;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutionException;

/**
 * @ClassName MedianFinder
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/27 9:05
 * @Version 1.0
 **/
public class MedianFinder {

    private static class Node {
        int item;
        Node next;
        Node pre;

        Node(int element) {
            this.item = element;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }

    Node first;

    Node mid;

    int size;

    public MedianFinder() {
        mid = first = null;
        size = 0;
    }

    public void addNum(int num) {
        Node node = new Node(num);
        node.setNext(null);
        node.setPre(null);
        if(first == null){
            mid = first = node;
        }else{
            Node p = first;
            Node r = null;
            boolean flag = false;
            while (p!=null && p.item < node.item){
                r = p;
                if (r==mid) flag = true;
                p = p.next;
            }
            if (r == null){
                node.setNext(first);
                first.setPre(node);
                first = node;
            }else {
                node.setNext(r.next);
                if (r.next != null) r.next.setPre(node);
                r.setNext(node);
                node.setPre(r);
            }
            if (flag&&size%2==0) mid = mid.next;
            if (!flag && size%2==1) mid = mid.pre;
        }
        size++;
    }

    public double findMedian() {
        if (size == 0) return 0;
        if(size%2 == 1){
            return 1.0*mid.item;
        }else{
            return (1.0*mid.item+ mid.next.item)/2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(6);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(10);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
    }
}
/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */