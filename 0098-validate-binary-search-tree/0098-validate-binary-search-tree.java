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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean checkBST(TreeNode root, long l, long r) {
        if(root==null) return true;
        if(l>=root.val || root.val>=r){
            return false;
        }
        return checkBST(root.left,l,root.val) && checkBST(root.right,root.val,r);
    }
}