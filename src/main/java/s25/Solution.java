package s25;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode p, q, r, l, t;
        l = new ListNode();
        t = l;
        l.next = head;
        p = q = head;
        while (p != null && q != null) {
            for (int i = 0; i < k - 1; i++) {
                if (q.next == null) return head;
                else {
                    q = q.next;
                }
            }
            r = q.next;
            while (p != q) {
                l.next = p.next;
                p.next = q.next;
                q.next = p;
                p = l.next;
            }
            q = p = r;
            while (l.next != r) {
                l = l.next;
            }
        }
        return t.next;
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
