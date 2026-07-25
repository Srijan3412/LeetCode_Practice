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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> inmap=new HashMap<>();
        int i=0;
        while(i<inorder.length){
            inmap.put(inorder[i],i++);
        }
        return bt(inorder,0,inorder.length-1,postorder,0,postorder.length-1,inmap);
    }

    public TreeNode bt(int[] inorder, int is, int ie, int[] postorder,int ps,int pe,Map<Integer, Integer> inmap) {
        if(is>ie || ps>pe){
            return null;
        }
        TreeNode root=new TreeNode(postorder[pe]);

        int index=inmap.get(root.val);
        int diffr=ie-index+1;
        int diffl=index-1-is;

        root.left=bt(inorder,is,index-1,postorder,ps,pe-diffr,inmap);
        root.right=bt(inorder,index+1,ie,postorder,pe-diffr,pe-1,inmap);

        return root;

    }

}