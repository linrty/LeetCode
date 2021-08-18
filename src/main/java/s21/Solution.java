package s21;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = new ListNode();
        ListNode p = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                p.next = new ListNode(l1.val, null);
                p = p.next;
                l1 = l1.next;
            } else {
                p.next = new ListNode(l2.val, null);
                p = p.next;
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            p.next = new ListNode(l1.val, null);
            p = p.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            p.next = new ListNode(l2.val, null);
            p = p.next;
            l2 = l2.next;
        }

        return head.next;
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
