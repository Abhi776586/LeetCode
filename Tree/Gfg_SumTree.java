package Tree;

class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class Solution {
    boolean isSumTree(Node root) {
        return sum(root) != -1;
        
        
    }
    int sum(Node root){
        if(root == null){
            return 0;
        }
        
        if(root.left == null && root.right == null){
            return root.data;
        }
        
        int left = sum(root.left);
        int right = sum(root.right);
        
        if(left == -1 || right == -1) return -1;
        if(root.data != left + right) return -1;
        
        return root.data + left + right;
        
    }
}
