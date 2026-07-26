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
    public int kthSmallest(TreeNode root, int k) {
        kth=k;
        finder(root);
        return n;
    }
    static int n=0;
    static int kth=0;
    public void finder(TreeNode root){
        if(root.left!=null){
            finder(root.left);
        }
        kth--;
        if(kth==0){
            n=root.val;
            return ;
        }
        if(root.right!=null){
            finder(root.right);
        }
      
    }










}