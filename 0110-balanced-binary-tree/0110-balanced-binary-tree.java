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
    public boolean isBalanced(TreeNode root) {
        
        if(treeIsBalanced(root)==-1){
            return false;
        }else{
            return true;
        }
    }
    public int treeIsBalanced(TreeNode root){
        if(root==null){
            return 0;
        }
        int leftDeepth=treeIsBalanced(root.left);
        if(leftDeepth==-1) return -1;
        int rightDeepth=treeIsBalanced(root.right);
        if(rightDeepth==-1) return -1;
        
        if(Math.abs(leftDeepth-rightDeepth)>1){
            return -1;
        } 

        return 1+Math.max(leftDeepth,rightDeepth);
    }
}