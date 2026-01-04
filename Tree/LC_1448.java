package Tree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root , root.val);
        
    }
    private int dfs(TreeNode root , int max){
        if(root == null){
            return 0;
        }

        int count = 0;
        if(root.val >= max){
            count++;
        }

        int newMax = Math.max(max , root.val);


        count += dfs(root.left , newMax);
        count += dfs(root.right , newMax);

        return count;

    }
}
