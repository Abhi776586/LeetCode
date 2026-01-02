package Tree;
import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        dfs(root, String.valueOf(root.val), result);
        return result;
    }

    private void dfs(TreeNode root, String path, List<String> result) {
        if (root.left == null && root.right == null) {
            result.add(path);
            return;
        }
        if (root.left != null) {
            dfs(root.left, path + "->" + root.left.val, result);
        }
        if (root.right != null) {
            dfs(root.right, path + "->" + root.right.val, result);
        }
    }
}

