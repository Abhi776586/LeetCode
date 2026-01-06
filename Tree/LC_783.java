package Tree;
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    Integer prev = null;
    int result = Integer.MAX_VALUE;
    public int minDiffInBST(TreeNode root) {
        if(root == null){
            return result;
        }

        // left
        minDiffInBST(root.left);
        if(prev != null){
            result = Math.min(result , root.val - prev);
        }
        prev = root.val;
        // right
        minDiffInBST(root.right);

        return result;
        
    }
}