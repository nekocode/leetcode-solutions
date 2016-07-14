/**
 * Created by nekocode on 16/7/14.
 */
public class _112 {

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;

        // 终止条件: root 节点为子叶
        if (root.left == null && root.right == null) return (sum - root.val) == 0;
        sum -= root.val;

        // 判断左右子树是否能找到和为 sum 的
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(5);
        tree.left = new TreeNode(4);
        tree.left.left = new TreeNode(11);
        tree.left.left.left = new TreeNode(7);
        tree.left.left.right = new TreeNode(2);
        tree.right = new TreeNode(8);
        tree.right.left = new TreeNode(13);
        tree.right.right = new TreeNode(4);
        tree.right.right.right = new TreeNode(1);

        System.out.print(new _112().hasPathSum(tree, 5));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
