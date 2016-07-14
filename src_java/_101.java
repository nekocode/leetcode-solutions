/**
 * Created by nekocode on 16/7/14.
 */
public class _101 {
    private boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == tree2) return true;
        else if (tree1 == null || tree2 == null || tree1.val != tree2.val) return false;
        return isSymmetric(tree1.left, tree2.right) && isSymmetric(tree1.right, tree2.left);
    }

    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.right = new TreeNode(2);
        tree.left.left = new TreeNode(3);
//        tree.left.right = new TreeNode(4);
//        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(3);

        System.out.print(new _101().isSymmetric(null));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
