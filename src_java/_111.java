/**
 * Created by nekocode on 16/7/15.
 */
public class _111 {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        // 终止条件: 当前节点为子叶
        if (root.left == null && root.right == null) return 1;

        if (root.left == null) return minDepth(root.right) + 1;
        if (root.right == null) return minDepth(root.left) + 1;

        return Math.min(minDepth(root.left) + 1, minDepth(root.right) + 1);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(0);
        tree.left = new TreeNode(0);
        tree.left.right = new TreeNode(0);
        tree.right = new TreeNode(0);
        tree.right.left = new TreeNode(0);
        tree.right.right = new TreeNode(0);

        System.out.print(new _111().minDepth(tree));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
