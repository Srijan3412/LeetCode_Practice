/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
import java.util.*;
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans=new LinkedList<>();
        Queue<TreeNode> que=new LinkedList<>();
        Map<Integer,TreeNode> parent=new HashMap<>();
        que.offer(root);
        while(!que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                if(node.left!=null){
                    parent.put(node.left.val,node);
                    que.offer(node.left);
                }
                if(node.right!=null){
                    parent.put(node.right.val,node);
                    que.offer(node.right);
                }
            }
        }
        que.offer(target);
        Map<Integer,Integer> Verified=new HashMap<>();
        
        while(k>0 && !que.isEmpty()){
            int size=que.size();
            for(int i=0;i<size;i++){
                TreeNode node=que.poll();
                Verified.put(node.val,1);
                if(node.left!=null && !Verified.containsKey(node.left.val)){
                    que.offer(node.left);
                }if(node.right!=null && !Verified.containsKey(node.right.val)){
                    que.offer(node.right);
                }if(parent.get(node.val)!=null && !Verified.containsKey(parent.get(node.val).val)){
                    que.offer((parent.get(node.val)));
                }
            }
            k--;
        }
        while(!que.isEmpty()){
            ans.add(que.poll().val);
        }
        return ans;
    }
}