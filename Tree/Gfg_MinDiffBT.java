package Tree;
// FUNCTION CODE
/* A Binary Tree node
class Node
{
    int data;
    Node left, right;
   Node(int item)    {
        data = item;
        left = right = null;
    }
} */

/* Should return minimum distance between a and b
   in a tree with given root*/
class GfG {
    int findDist(Node root, int a, int b) {
        Node lca = findLCA(root , a , b);
        int d1 = findedge(lca , a , 0);
        int d2 = findedge(lca , b , 0);
        return d1 + d2;
    }
    
    Node findLCA(Node root , int a , int b){
        if(root == null){
            return null;
        }
        if(root.data == a || root.data == b){
            return root;
        }
        
        Node left = findLCA(root.left , a , b);
        Node right = findLCA(root.right , a , b);
        
        if(left != null && right != null){
            return root;
        }
        else if(left != null){
            return left;
        }
        else{
            return right;
        }
    }
    int findedge(Node root , int val , int edge){
        if(root == null){
            return -1;
        }
        if(root.data == val){
            return edge;
        }
        int left = findedge(root.left , val , edge + 1);
        if(left != -1){
            return left;
        }
        return findedge(root.right , val , edge + 1);
    }
}