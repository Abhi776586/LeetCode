package Tree;

public class Gfg_lock {
static class Node {
    int data;
    Node left, right, parent;
    boolean isLocked;
    int lockedBy;
    int lockedDescendantCount;

    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.isLocked = false;
        this.lockedBy = -1;
        this.lockedDescendantCount = 0;
    }
}
public boolean lock(Node node, int userId){
    //already locked
    if(node.isLocked){
        return false;
    }
    //descendant locked
    if(node.lockedDescendantCount > 0){
        return false;
    }
    //ancestor locked
    Node curr = node.parent;
    while(curr != null){
        if(curr.isLocked){
            return false;
        }
        else{
            curr = curr.parent;
        }
    }
    //lock the node
    node.isLocked = true;
    node.lockedBy = userId;
    //update ancestors
    curr = node.parent;
    while(curr != null){
        curr.lockedDescendantCount += 1;
        curr = curr.parent;
    }
    return true;
}
public boolean unlock(Node node, int  userId){

    //not locked
    if(!node.isLocked){
        return false;
    }
    //locked by other user

    if(node.lockedBy != userId){
        return false;
    }
    node.isLocked = false;
    node.lockedBy = -1;

    //update ancestors
    Node curr = node.parent;
    while(curr != null){
        curr.lockedDescendantCount -= 1;
        curr = curr.parent;
    }
    return true;
}
}