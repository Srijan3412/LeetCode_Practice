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
public class Codec {
    
    StringBuilder sb = new StringBuilder();
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null){
            sb.append("null ");
            return sb.toString();
        }
        sb.append(String.valueOf(root.val)+" ");

        serialize(root.left);
        serialize(root.right);
        return sb.toString();
    }
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str=data.split(" ");
        return des(str);
    }

    int i=0;

    public TreeNode des(String[] str){
        if(str[i].equals("null")){
            i++;
            return null;
        }
        else{
            TreeNode root=new TreeNode(Integer.parseInt(str[i++]));

            root.left=des(str);
            root.right=des(str);
            
            return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));