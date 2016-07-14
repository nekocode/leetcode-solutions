import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by nekocode on 16/7/9.
 */
public class _141 {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = p1;

        do {
            // 链表有断口的话说明无循环
            if (p1 == null || p2 == null || p2.next == null) return false;

            // p1、p2 以不同速度前进
            p1 = p1.next;
            p2 = p2.next.next;
        } while (p1 != p2);

        return true;
    }

    public boolean hasCycle2(ListNode head) {
        HashSet<ListNode> map = new HashSet<>();

        while (head != null) {
            if (map.contains(head)) {
                return true;
            } else {
                map.add(head);
            }

            head = head.next;
        }

        return false;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        list.next = new ListNode(1);
        list.next.next = new ListNode(2);
        list.next.next.next = list.next.next;

        System.out.print(new _141().hasCycle(list));
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null;}
    }
}
