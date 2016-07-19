/**
 * Created by nekocode on 16/7/19.
 */
public class _234 {
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;

        int len = 0;
        for (ListNode node = head; node != null; node = node.next, len ++);
        ListNode midPreviousNode = head;
        int midPos = (int)(len / 2.0f - 0.5f);
        for (int i = 0; i != midPos; i ++, midPreviousNode = midPreviousNode.next);

        // 从 midPreviousNode 开始反转后半部分
        ListNode tail = midPreviousNode.next;
        if (tail != null) {
            while (tail.next != null) {
                ListNode newHaed = tail.next;
                tail.next = newHaed.next;
                newHaed.next = midPreviousNode.next;
                midPreviousNode.next = newHaed;
            }
        }

        for (ListNode node = head, midNode = midPreviousNode.next;
             midNode != null;
             node = node.next, midNode = midNode.next) {
            if (node.val != midNode.val) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(0);
//        list.next = new ListNode(1);
//        list.next.next = new ListNode(2);
//        list.next.next.next = new ListNode(1);
//        list.next.next.next.next = new ListNode(0);

        System.out.println(new _234().isPalindrome(list));
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
