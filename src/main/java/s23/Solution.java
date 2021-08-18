package s23;

public class Solution {
    public static void main(String[] args) {

    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode();
        ListNode p = head;
        while (true) {
            int maxi = Integer.MAX_VALUE;
            int pos = -1;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) continue;
                if (lists[i].val < maxi) {
                    maxi = lists[i].val;
                    pos = i;
                }
            }
            if (pos == -1) break;
            else {
                p.next = new ListNode(maxi, null);
                lists[pos] = lists[pos].next;
                p = p.next;
            }
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
