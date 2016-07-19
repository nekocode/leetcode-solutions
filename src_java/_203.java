/**
 * Created by nekocode on 16/7/19.
 */
public class _203 {
    public ListNode removeElements(ListNode head, int val) {
        // 处理头部
        while (head != null && head.val == val) {
            head = head.next;
        }

        for (ListNode node = head, lastNormalNode = null; node != null; node = node.next) {
            if (node.val == val) {
                lastNormalNode.next = node.next;
            } else {
                lastNormalNode = node;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(2);
        list.next.next = new ListNode(2);
        list.next.next.next = new ListNode(1);

        list = new _203().removeElements(list, 2);

        for (ListNode n = list; n != null; n = n.next) {
            System.out.print(n.val + ", ");
        }
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
