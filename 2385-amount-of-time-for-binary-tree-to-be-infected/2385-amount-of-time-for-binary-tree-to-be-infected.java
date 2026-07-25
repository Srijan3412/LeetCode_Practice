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
    public int amountOfTime(TreeNode root, int start) {
        if(root==null) return 0;
        Map<Integer,TreeNode> parent=new HashMap<>();
        Map<Integer,TreeNode> visited=new HashMap<>();
        Queue<TreeNode> que=new LinkedList<>();
        que.add(root);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                if(start==node.val) visited.put(node.val,node);
                if(node.left!=null){
                    que.offer(node.left);
                    parent.put(node.left.val,node);
                }
                if(node.right!=null){
                    que.offer(node.right);
                    parent.put(node.right.val,node);
                }
            }
        }
        int k=-1;
        que.offer(visited.get(start));
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                if(node.left!=null && !visited.containsKey(node.left.val)){
                    que.offer(node.left);
                    visited.put(node.left.val,node.left);
                }
                if(node.right!=null && !visited.containsKey(node.right.val)){
                    que.offer(node.right);
                    visited.put(node.right.val,node.right);
                }
                if(parent.get(node.val)!=null && !visited.containsKey(parent.get(node.val).val)){
                    que.offer(parent.get(node.val));
                    visited.put(parent.get(node.val).val,parent.get(node.val));
                }
            }
            k++;
        }
        return k;

    }

}