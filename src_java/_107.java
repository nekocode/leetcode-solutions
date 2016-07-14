import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by nekocode on 16/7/13.
 */
public class _107 {
    private List<TreeNode> getNextLevelTree(List<TreeNode> nowLevelTree) {
        List<TreeNode> rlt = new ArrayList<>();
        for (TreeNode node : nowLevelTree) {
            if (node.left != null) rlt.add(node.left);
            if (node.right != null) rlt.add(node.right);
        }
        return rlt;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<TreeNode>> levelTrees = new ArrayList<>();

        List<TreeNode> levelTree = new ArrayList<>();
        if (root != null) levelTree.add(root);
        while (levelTree.size() != 0) {
            levelTrees.add(0, levelTree);

            levelTree = getNextLevelTree(levelTree);
        }

        List<List<Integer>> rlt = new ArrayList<>();
        for (List<TreeNode> level : levelTrees) {
            List<Integer> list = new ArrayList<>();
            for (TreeNode node : level) {
                list.add(node.val);
            }
            rlt.add(list);
        }

        return rlt;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(3);
        tree.left = new TreeNode(9);
        tree.right = new TreeNode(20);
        tree.right.left = new TreeNode(15);
        tree.right.right = new TreeNode(7);

        List<List<Integer>> rlt = new _107().levelOrderBottom(tree);

        for (List<Integer> level : rlt) {
            for (Integer integer : level) {
                System.out.print(integer + ", ");
            }
            System.out.print("\n");
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
