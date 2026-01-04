package Tree;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {

    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root , distance);
        return count;
        
    }
    private int[] dfs(TreeNode node , int distance){
        if(node == null){
            return new int[0];
        }
        if(node.left == null && node.right == null){
            return new int[]{1};
        }

        int[] left = dfs(node.left , distance);
        int[] right = dfs(node.right , distance);

        for(int i = 0 ; i < left.length; i++){
            for(int j = 0; j < right.length; j++){
                if(left[i] + right[j] <= distance){
                    count++;
                }
            }
        }

        int[] temp = new int[left.length + right.length];
        int idx = 0;

        for(int i = 0 ; i < left.length; i++){
            if(left[i] + 1 < distance){
                temp[idx++] = left[i] + 1;
            }
        }

        for(int j = 0 ; j < right.length; j++){
            if(right[j] + 1 < distance){
                temp[idx++] = right[j] + 1;
            }
        }

        int[] res = new int[idx];
        System.arraycopy(temp , 0 , res , 0 , idx);
        return res;

    }
}