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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Deque<TreeNode> que=new LinkedList<>();
        List<List<Integer>> ans=new LinkedList<>();
        if(root==null) return ans;
        boolean isReverse=false;
        que.add(root);
        int size=0;
        while(!que.isEmpty()){
            size=que.size();
            List<Integer> current=new LinkedList<>();
            for(int i=0;i<size;i++){
                if(!isReverse){
                    TreeNode curr=que.pollFirst();
                    current.add(curr.val);
                    if(curr.left!=null) que.addLast(curr.left);
                    if(curr.right!=null) que.addLast(curr.right);
                }else{
                    TreeNode curr=que.pollLast();
                    current.add(curr.val);
                    if(curr.right!=null) que.addFirst(curr.right);
                    if(curr.left!=null) que.addFirst(curr.left);
                }
            }
            isReverse=!isReverse;
            ans.add(current);
        }return ans;
    }
}