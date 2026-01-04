package Tree;
import java.util.ArrayList;
import java.util.Stack; 
/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        if(!isLeaf(root)){
            result.add(root.data);
        }
        addLeftBoundary(root , result);
        addLeaves(root , result);
        addRightBoundary(root , result);
        
        return result;
    }
    boolean isLeaf(Node node){
        return node.left == null && node.right == null;
    }
    
    void addLeftBoundary(Node root , ArrayList<Integer> result){
       Node curr = root.left;
       while(curr != null){
           if(!isLeaf(curr)){
               result.add(curr.data);
           }
           if(curr.left != null){
               curr = curr.left;
           }
           else{
               curr = curr.right;
           }
       }
       
    }
    void addLeaves(Node root , ArrayList<Integer> result){
        if(root == null){
           return;
        }
        if(isLeaf(root)){
            result.add(root.data);
            return;
        }
        addLeaves(root.left , result);
        addLeaves(root.right , result);
        
    }
    void addRightBoundary(Node root , ArrayList<Integer> result){
        Node curr = root.right;
        Stack<Integer> st = new Stack<>();
        while(curr != null){
            if(!isLeaf(curr)){
                st.push(curr.data);
            }
            if(curr.right != null){
                curr = curr.right;
            }
            else{
                curr = curr.left;
            }
        }
        while(!st.isEmpty()){
            result.add(st.pop());
        }
    }
}
