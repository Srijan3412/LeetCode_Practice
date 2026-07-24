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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode,Integer>> que=new LinkedList<>();
        que.add(new Pair<>(root,0));
        int max=0;
        while(!que.isEmpty()){
            int size=que.size();
            int levelStart=que.peek().getValue();
            int index=0;

            for(int i=0;i<size;i++){
                Pair<TreeNode,Integer> l=que.poll();
                TreeNode node=l.getKey();
                index=l.getValue();
                if(node.left!=null){
                    que.add(new Pair<>(node.left,2*index));
                }
                if(node.right!=null){
                    que.add(new Pair<>(node.right,2*index+1));
                }
            }
            max=Math.max(max,index-levelStart+1);

        }
        return max;
    }
}