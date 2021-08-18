package s61;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/17 15:15
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode p = head;
        ListNode q = head;
        int num = 0;
        while (p.next != null) {
            p = p.next;
            num++;
        }
        num++;
        k = k % num;
        if (k == 0) return head;
        k = num - k;
        while (k != 0) {
            p.next = q;
            q = q.next;
            p = p.next;
            p.next = null;
            k--;
        }
        return q;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
