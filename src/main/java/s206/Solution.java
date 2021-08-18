package s206;

/**
 * @ClassName Solution
 * @Description TODO
 * @Author Linrty
 * @Date 2021/8/18 19:56
 * @Version 1.0
 **/
public class Solution {
    public static void main(String[] args) {

    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p, q, r;
        p = q = r = head;
        q = r = head.next;
        while (q != null) {
            r = r.next;
            q.next = p;
            p = q;
            q = r;
        }
        return p;
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
