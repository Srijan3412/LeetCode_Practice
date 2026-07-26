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
    public TreeNode searchBST(TreeNode root, int val) {
        return BST(root,val);
    }
    
    public TreeNode BST(TreeNode root,int val) {
        if(root==null) return null;
        
        if(root.val<val){
            root=BST(root.right,val);
        } 
        else if(root.val>val){
            root=BST(root.left,val);
        } 
        return root;
    }
}