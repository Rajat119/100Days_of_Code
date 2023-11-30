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
    public boolean isCompleteTree(TreeNode root) {
        if(root == null)    return true;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        boolean check = false;
        while(!q1.isEmpty()){
            TreeNode current = q1.poll();
            if(current == null) check = true;
            else{
                if(check)   return false;
                q1.offer(current.left);
                q1.offer(current.right);
            }
        }
        return true;
    }
}