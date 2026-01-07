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
    static class Tuple {
    TreeNode node;
    int row;
    int col;

    Tuple(TreeNode node, int row, int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        TreeMap<Integer , TreeMap<Integer , PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root , 0 , 0));

        while(!q.isEmpty()){
            Tuple t = q.poll();
            TreeNode node = t.node;
            int row = t.row;
            int col = t.col;
        if(node == null){
            continue;
        }
        if(!map.containsKey(col)){
            map.put(col , new TreeMap<>());
        }
        if(!map.get(col).containsKey(row)){
            map.get(col).put(row , new PriorityQueue<>());
        }
        map.get(col).get(row).add(node.val);
        //left
        q.add(new Tuple(node.left , row + 1 , col - 1));
        //right
        q.add(new Tuple(node.right , row + 1 , col + 1));

        }
        List<List<Integer>> result = new ArrayList<>();
        for(TreeMap<Integer , PriorityQueue<Integer>> rows : map.values()){
            List<Integer> colList = new ArrayList<>();
            for(PriorityQueue<Integer> pq : rows.values()){
                while(!pq.isEmpty()){
                    colList.add(pq.poll());
                }
            }
            result.add(colList);
        }
        return result;
        
    }
}
