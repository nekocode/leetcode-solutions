/**
 * Created by nekocode on 16/7/14.
 */
public class _110 {
    public int height(TreeNode tree) {
        if (tree == null) return 0;
        tree.val = 1 + Math.max(height(tree.left), height(tree.right));
        return tree.val;
    }

    private boolean isBalanced(TreeNode left, TreeNode right) {
        int leftHeight = 0, rightHeight = 0;
        if (left != null) leftHeight = left.val;
        if (right != null) rightHeight = right.val;

        return Math.abs(leftHeight - rightHeight) < 2 && isBalanced(left) && isBalanced(right);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        height(root);
        return isBalanced(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(1);
        tree.right = new TreeNode(2);
        tree.right.right = new TreeNode(3);
        tree.right.right.right = new TreeNode(3);

        System.out.print(new _110().isBalanced(tree));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
