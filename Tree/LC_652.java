package Tree;
import java.util.*;
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
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        Map<String , Integer> subTree = new HashMap<>();
        Map<Integer , Integer> count = new HashMap<>();
        List<TreeNode> result = new ArrayList<>();
        int[] idCount = {1};
        traverse(root , subTree , count , result , idCount);
        return result;
        
    }

    private int traverse(TreeNode root , Map<String , Integer> subTree , Map<Integer , Integer> count , List<TreeNode> result , int[] idCount){
        if(root == null){
            return 0;
        }

        int leftId = traverse(root.left , subTree , count , result , idCount);
        int rightId = traverse(root.right , subTree , count , result , idCount);

        String key = leftId + "," + root.val + "," + rightId;

        if(!subTree.containsKey(key)){
            subTree.put(key , idCount[0]++);
        }

        int id = subTree.get(key);
        count.put(id , count.getOrDefault(id , 0) + 1);

        if(count.get(id) == 2){
            result.add(root);
        }
        return id;

    }
}