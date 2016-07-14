/**
 * Created by nekocode on 16/7/13.
 */
public class _21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 特殊情况
        if (l1 == null) return l2;
        else if (l2 == null) return l1;

        // 混合后链表的头部
        ListNode head;

        // 判断升序 or 降序
        int isAsc = 0;
        for (ListNode p1 = l1; p1.next != null && isAsc == 0; p1 = p1.next) {
            isAsc = l1.next.val - l1.val;
        }
        for (ListNode p2 = l2; p2.next != null && isAsc == 0; p2 = p2.next) {
            isAsc = l2.next.val - l2.val;
        }

        if (isAsc >= 0) {
            // 如果是升序的话
            // 记录 l2 的头部
            ListNode l2Header = l2;

            // 选择更小的作为头部
            if (l2.val < l1.val) {
                head = l2;

                // 找到 l2 中最后一个比 l1 头部小的节点
                ListNode p2 = l2;
                while (p2.next != null && p2.next.val < l1.val) {
                    p2 = p2.next;
                }

                // 更改 l2 的新头部, 并将 l2 中比 l1 小的部分连接到 l1 上
                l2Header = p2.next;
                p2.next = l1;

            } else {
                head = l1;
            }

            // 把 l2 剩余大于等于 l1 头部的节点插入 l1 中
            for (ListNode p2 = l2Header; p2 != null; ) {
                ListNode next = p2.next;

                for (ListNode p1 = l1; ; p1 = p1.next) {
                    if (p1.next == null || (p2.val >= p1.val && p2.val <= p1.next.val)) {
                        // p2 插入 l1 中
                        ListNode tmp = p1.next;
                        p1.next = p2;
                        p2.next = tmp;

                        break;
                    }
                }

                p2 = next;
            }

        } else {
            // 如果是降序的话
            // 记录 l2 的头部
            ListNode l2Header = l2;

            // 选择更大的作为头部
            if (l2.val > l1.val) {
                head = l2;

                // 找到 l2 中最后一个比 l1 头部大的节点
                ListNode p2 = l2;
                while (p2.next != null && p2.next.val > l1.val) {
                    p2 = p2.next;
                }

                // 更改 l2 的新头部, 并将 l2 中比 l1 大的部分连接到 l1 上
                l2Header = p2.next;
                p2.next = l1;

            } else {
                head = l1;
            }

            // 把 l2 剩余小于等于 l1 头部的节点插入 l1 中
            for (ListNode p2 = l2Header; p2 != null; ) {
                ListNode next = p2.next;

                for (ListNode p1 = l1; ; p1 = p1.next) {
                    if (p1.next == null || (p2.val <= p1.val && p2.val >= p1.next.val)) {
                        // p2 插入 l1 中
                        ListNode tmp = p1.next;
                        p1.next = p2;
                        p2.next = tmp;

                        break;
                    }
                }

                p2 = next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode list = new ListNode(1);
        list.next = new ListNode(3);
        list.next.next = new ListNode(4);

        ListNode list2 = new ListNode(-1);
        list2.next = new ListNode(0);
        list2.next.next = new ListNode(2);

        ListNode rlt = new _21().mergeTwoLists(list, list2);

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
