package s19;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p, q;
        p = q = head;
        int sub = 0;
        while (q.next != null) {
            if (sub == n) {
                q = q.next;
                p = p.next;
            } else {
                sub++;
                q = q.next;
            }
        }
        if (sub == n) p.next = p.next.next;
        else head = head.next;
        return head;
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
