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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map=new HashMap<>();
        int i=0;
        while(i<inorder.length){
            map.put(inorder[i],i++);
        }
        return bt(preorder,0,preorder.length-1,inorder,0,inorder.length-1,map);
    }
    public TreeNode bt(int[] preorder, int ps, int pe, int[] inorder, int is, int ie, Map<Integer, Integer> inmap) {
        
        if(ps>pe || is>ie) return null;

        TreeNode root=new TreeNode(preorder[ps]);

        int index=inmap.get(root.val);
        int diffl=inmap.get(root.val)-is;
        int diffr=ie-inmap.get(root.val)+1;
        
        root.left=bt(preorder,ps+1,ps+1+diffl,inorder,is,index-1,inmap);
        root.right=bt(preorder,ps+1+diffl,pe,inorder,index+1,ie,inmap);

        return root;
    }
}