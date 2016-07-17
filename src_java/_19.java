/**
 * Created by nekocode on 16/7/17.
 */
public class _19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (n == 0) return head;

        ListNode toRemove = null;
        ListNode beforeToRemove = null;
        int th = 1;
        for (ListNode now = head; now != null; now = now.next) {
            if (toRemove == null && th == n) {
                toRemove = head;
                continue;
            }
            if (toRemove == null) th++;

            if (beforeToRemove == null) beforeToRemove = toRemove;
            else beforeToRemove = beforeToRemove.next;
            if (toRemove != null) toRemove = toRemove.next;
        }

        if (toRemove == head) {
            return toRemove.next;
        } else {
            beforeToRemove.next = toRemove.next;
            return head;
        }
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(4);

        list = new _19().removeNthFromEnd(list, 5);

        for (ListNode now = list; now != null; now = now.next) {
            System.out.print(now.val + ", ");
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null;}
    }
}
