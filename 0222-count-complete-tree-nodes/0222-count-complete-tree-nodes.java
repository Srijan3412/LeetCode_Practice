/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() 
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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        
        int left=heightLeft(root);
        int right=heightRight(root);

        if(left==right){
            return (int)Math.pow(2, left) - 1;
        }


        return 1+countNodes(root.left)+countNodes(root.right);
    }
    public int heightLeft(TreeNode root) {
        int h=0;
        while(root!=null){
            root=root.left;
            h++;
        }
        return h;
    }
    public int heightRight(TreeNode root) {
        int h=0;
        while(root!=null){
            root=root.right;
            h++;
        }
        return h;
    }
}