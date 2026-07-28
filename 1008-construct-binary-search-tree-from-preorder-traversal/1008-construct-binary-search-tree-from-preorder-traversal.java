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
    public TreeNode bstFromPreorder(int[] preorder) {
        
        TreeNode root=new TreeNode(preorder[0]);
        return bstFrom(preorder,Integer.MAX_VALUE);

    }
    int i=0;
    public TreeNode bstFrom(int[] preorder,int bound) {
        if(i==preorder.length || preorder[i] > bound) return null;
        

        TreeNode node=new TreeNode(preorder[i++]);
        
        node.left=bstFrom(preorder,node.val);
        node.right=bstFrom(preorder,bound);
        
        return node;
    }

}