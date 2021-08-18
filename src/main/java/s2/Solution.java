package s2;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode p = null;
        int pre = 0;
        while (l1 != null && l2 != null) {
            int num = l1.val + l2.val + pre;
            ListNode listNode = new ListNode();
            listNode.val = num % 10;
            pre = num / 10;
            listNode.next = null;
            if (ans == null) ans = listNode;
            else p.next = listNode;
            p = listNode;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int num = l1.val + pre;
            ListNode listNode = new ListNode();
            listNode.val = num % 10;
            pre = num / 10;
            listNode.next = null;
            if (ans == null) ans = listNode;
            else p.next = listNode;
            p = listNode;
            l1 = l1.next;
        }
        while (l2 != null) {
            int num = l2.val + pre;
            ListNode listNode = new ListNode();
            listNode.val = num % 10;
            pre = num / 10;
            listNode.next = null;
            if (ans == null) ans = listNode;
            else p.next = listNode;
            p = listNode;
            l2 = l2.next;
        }
        if (pre != 0) {
            ListNode listNode = new ListNode();
            listNode.val = pre;
            listNode.next = null;
        }
        return ans;
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
