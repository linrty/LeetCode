package s876;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode middleNode(ListNode head) {
        ListNode p, q;
        p = q = head;
        while (q.next != null) {
            if (p.next == null) {
                return p;
            } else {
                p = p.next;
                if (q.next == null) {
                    return p;
                } else {
                    q = q.next;
                }
                if (q.next == null) {
                    return p;
                } else {
                    q = q.next;
                }
            }
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
