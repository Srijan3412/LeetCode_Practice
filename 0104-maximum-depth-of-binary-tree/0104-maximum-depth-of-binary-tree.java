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
import java.util.*;
class Solution {
    public int maxDepth(TreeNode root) {
        // if(root==null){
        //     return 0;
        // }
        // int level=0;
        // Queue<TreeNode> que=new LinkedList<>();
        // que.add(root);
        // while(!que.isEmpty()){
        //     int size=que.size();
        //     for(int i=0;i<size;i++){
        //         TreeNode current=que.poll();
        //         if(current.left!=null){
        //             que.add(current.left);
        //         }
        //         if(current.right!=null){
        //             que.add(current.right);
        //         }
        //     }
        //     level++;
        // }
        // return level;
        if(root!=null){
            return deep(root,0);
        }return 0;
    }
    public int deep(TreeNode root,int h) {
        if(root==null){
            return h;
        }
        int leftDepth=deep(root.left,h+1);
        int rightDepth=deep(root.right,h+1);
        return Math.max(leftDepth,rightDepth);
    }
}