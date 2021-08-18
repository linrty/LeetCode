package s24;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode p, q;
        p = head;
        q = head.next;
        while (p != null && q != null) {
            int x = q.val;
            q.val = p.val;
            p.val = q.val;
            if (q.next == null) break;
            else q = q.next;
            if (q.next == null) break;
            else q = q.next;
            p = p.next;
            p = p.next;
        }
        return head;
    }

    public static class ListNode {
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
