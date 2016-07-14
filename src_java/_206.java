/**
 * Created by nekocode on 16/7/6.
 */
public class _206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        ListNode tail = head;

        while (tail.next != null) {
            ListNode newHead = tail.next;
            tail.next = newHead.next;
            newHead.next = head;
            head = newHead;
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);

        head = new _206().reverseList(head);

        ListNode node = head;
        while (node != null) {
            System.out.print(node.val + ", ");
            node = node.next;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
