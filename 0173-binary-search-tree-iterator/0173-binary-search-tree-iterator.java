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
class BSTIterator {
        
    Stack<TreeNode> st=new Stack<>();
    TreeNode newN=new TreeNode();

    public BSTIterator(TreeNode root) {
        newN=root;
        while (newN != null) {
            st.push(newN);
            newN = newN.left;
        }
    }
    
    public int next() {
        
        TreeNode ans=st.peek();
        newN=st.pop();
        if(newN.right!=null){
            newN=newN.right;
            while(newN!=null){
                st.push(newN);
                newN=newN.left;
            }
        }
        return ans.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */