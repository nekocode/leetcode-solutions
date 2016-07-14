import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nekocode on 16/7/8.
 */
public class _235 {
    public boolean search(ArrayList<TreeNode> path, TreeNode root, TreeNode targetNode) {
        // 终止条件
        if (root == null || targetNode == null) return false;

        // 终止条件
        if (root.val == targetNode.val) {
            path.add(root);
            return true;
        }

        // 搜索左右子叶
        if (search(path, root.left, targetNode) || search(path, root.right, targetNode)) {
            // 如果子叶中有搜索到的话,说明经过当前节点
            path.add(root);
            return true;
        }

        return false;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 首先使用深度搜索找到两个节点的路径
        // 第一个目标子叶的路径
        ArrayList<TreeNode> path1 = new ArrayList<>();
        search(path1, root, p);

        // 第二个目标子叶的路径
        ArrayList<TreeNode> path2 = new ArrayList<>();
        search(path2, root, q);

//        // 对比两个路径,找出最小公共祖先
//        TreeNode lowest = null;
//        HashMap<Integer, Boolean> map = new HashMap<>();
//        for (TreeNode node : path1) map.put(node.val, true);
//        for (TreeNode node : path2) {
//            if (map.containsKey(node.val)) {
//                if (lowest == null || lowest.val > node.val) {
//                    lowest = node;
//                }
//            }
//        }

        // 对比两个路径,找出最低共祖先
        TreeNode lowest = null;
        int minDepthLen = Math.min(path1.size(), path2.size());
        // 注意路径是反向的
        for (int i = 0; i < minDepthLen; i++) {
            TreeNode node = path1.get(path1.size() - i - 1);
            if (node != path2.get(path2.size() - i - 1)) break;
            lowest = node;
        }
        return lowest;
    }

    public static void main(String[] args) {
        _235 p = new _235();
        TreeNode tree = new TreeNode(2);
        tree.left = new TreeNode(1);

        System.out.print(p.lowestCommonAncestor(tree, tree, tree.left).val);
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
