import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by nekocode on 16/7/18.
 */
public class _257 {
    private List<List<Integer>> record = new ArrayList<>();

    private void binaryTreePaths(TreeNode root, ArrayList<Integer> list) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            // 当前节点为子叶节点
            list.add(root.val);
            record.add(list);

        } else {
            // 普通节点
            list.add(root.val);

            if (root.left != null) {
                // 注意下面两句不能调换顺序, 因为第二句会影响
                if (root.right != null) binaryTreePaths(root.right, new ArrayList<>(list));
                binaryTreePaths(root.left, list);

            } else {
                // root.right != null
                binaryTreePaths(root.right, list);
            }
        }
    }

    public List<String> binaryTreePaths(TreeNode root) {
        record = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>());

        List<String> rlt = new ArrayList<>();
        for (List<Integer> list : record) {
            StringBuffer buffer = new StringBuffer();

            Iterator<Integer> it = list.iterator();
            if (it.hasNext()) {
                while (true) {
                    buffer.append(it.next());
                    if (it.hasNext()) buffer.append("->");
                    else break;
                }
            }

            rlt.add(new String(buffer));
        }

        return rlt;
    }

    public static void main(String[] args) {
        TreeNode tree = new TreeNode(1);
        tree.left = new TreeNode(2);
        tree.left.right = new TreeNode(5);
        tree.right = new TreeNode(3);
        tree.right.left = new TreeNode(4);
        tree.right.right = new TreeNode(7);

        for (String str : new _257().binaryTreePaths(tree)) {
            System.out.print(str + "\n");
        }
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
