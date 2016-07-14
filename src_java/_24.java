/**
 * Created by nekocode on 16/7/13.
 */
public class _24 {
    public ListNode swapPairs(ListNode head) {
        ListNode l = null, r = null, oldr = null;
        ListNode p = head;

        for (int i = 0; p != null; i ++) {
            switch (i % 2) {
                case 0:
                    l = p;
                    p = p.next;
                    break;

                case 1:
                    r = p;
                    p = p.next;

                    l.next = r.next;
                    r.next = l;
                    if (oldr != null) oldr.next = r;
                    oldr = l;

                    if (i == 1) head = r;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(3);
        list.next.next.next = new ListNode(4);

        ListNode rlt = new _24().swapPairs(null);

        for (ListNode node = rlt; node != null; node = node.next) {
            System.out.print(node.val + ", ");
        }
    }

    private static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
