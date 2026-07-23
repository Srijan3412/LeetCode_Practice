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
    int res=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        diameterOfTree(root,0);
        return res;
    }
    public int diameterOfTree(TreeNode root,int h){
        if(root==null) return 0;

        int leftHeight=diameterOfTree(root.left,h+1);
        int rightHeight=diameterOfTree(root.right,h+1);

        res=Math.max(res,leftHeight+rightHeight);

        return 1+Math.max(leftHeight,rightHeight);
    }
}