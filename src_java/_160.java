import java.util.ArrayList;

/**
 * Created by nekocode on 16/7/17.
 */
public class _160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pa = headA, pb = headB;
        boolean swapped = false;
        while (true) {
            if (pa == pb) return pb;

            pa = pa.next;
            pb = pb.next;

            if (pa == null) {
                if (!swapped) {
                    pa = headB;
                    swapped = true;
                } else {
                    break;
                }
            }
            if (pb == null) pb = headA;
        }

        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        ArrayList<Integer> valsB = new ArrayList<>();
        for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
            valsB.add(nodeB.val);
        }
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            nodeA.val++;
        }

        ListNode rlt = null;
        ListNode nodeB = headB;
        for (int valB : valsB) {
            if (valB != nodeB.val) {
                rlt = nodeB;
                break;
            }
            nodeB = nodeB.next;
        }
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            nodeA.val--;
        }
        return rlt;
    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        for (ListNode nodeA = headA; nodeA != null; nodeA = nodeA.next) {
            for (ListNode nodeB = headB; nodeB != null; nodeB = nodeB.next) {
                if (nodeB == nodeA) return nodeB;
            }
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(0);
        a.next = new ListNode(1);
        a.next.next = new ListNode(2);
        a.next.next.next = new ListNode(3);

        ListNode b = new ListNode(-1);
        b.next = new ListNode(-2);
        b.next.next = a.next.next.next;

        System.out.print(new _160().getIntersectionNode(a, b).val);
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; next = null;}
    }
}
