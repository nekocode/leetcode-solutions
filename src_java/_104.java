/**
 * Created by nekocode on 16/6/27.
 */
public class _104 {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int leftDepth =  1 + maxDepth(root.left);
        int rightDepth =  1 + maxDepth(root.right);
        return leftDepth > rightDepth ? leftDepth : rightDepth;
    }

    public static void main(String[] args) {
        _104 p = new _104();
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(0);
        tree.right = new TreeNode(0);
        tree.right.right = new TreeNode(0);
        tree.right.right.left = new TreeNode(0);

        System.out.print(p.maxDepth(tree));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
