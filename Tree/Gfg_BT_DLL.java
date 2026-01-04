package Tree;
class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

class Solution {

    Node head = null;
    Node temp = null;

    Node bToDLL(Node root) {
        if (root == null) {
            return null;   // handle empty tree
        }
        inorder(root);
        return head;
    }

    private void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        if (temp == null) {
            head = root;          // first node
        } else {
            temp.right = root;    // link prev → curr
            root.left = temp;     // link curr → prev
        }
        temp = root;              // move forward

        inorder(root.right);
    }
}

