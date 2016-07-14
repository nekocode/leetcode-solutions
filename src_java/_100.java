/**
 * Created by nekocode on 16/6/28.
 */
public class _100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 防止下一句产生 NPE
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;

        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        _100 p = new _100();
        TreeNode t1 = new TreeNode(0);
        t1.left = new TreeNode(1);
        t1.right = new TreeNode(2);

        TreeNode t2 = new TreeNode(0);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);

        System.out.print(p.isSameTree(t1, t2));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
