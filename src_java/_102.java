import java.util.ArrayList;
import java.util.List;

/**
 * Created by nekocode on 16/7/14.
 */
public class _102 {
    private List<Integer> getLevel(List<TreeNode> nowRow, ArrayList<TreeNode> nextRow) {
        List<Integer> row = new ArrayList<>();
        if (nowRow == null) return row;

        for (TreeNode node : nowRow) {
            row.add(node.val);
            if (node.left != null) nextRow.add(node.left);
            if (node.right != null) nextRow.add(node.right);
        }

        return row;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rlt = new ArrayList<>();
        if (root == null) return rlt;

        ArrayList<TreeNode> nowRow;
        ArrayList<TreeNode> nextRow = new ArrayList<>();
        nextRow.add(root);

        do {
            nowRow = nextRow;
            nextRow = new ArrayList<>();
            rlt.add(getLevel(nowRow, nextRow));
        } while (nextRow.size() != 0);

        return rlt;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.left.right = new TreeNode(7);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        List<List<Integer>> rlt = new _102().levelOrder(tree);

        for (List<Integer> row : rlt) {
            for (Integer val : row) {
                System.out.print(val + ", ");
            }
            System.out.print("\n");
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
