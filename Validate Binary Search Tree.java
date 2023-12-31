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
    public boolean isValidBST(TreeNode root) {
       return  helper(root,null,null);
    }
    boolean helper(TreeNode node , Integer low , Integer high){
        // Base Condition
        if(node==null) return true;

        if(high!=null && node.val>=high) return false;

        if(low!=null && node.val<=low) return false;

        boolean left = helper(node.left,low,node.val);
        boolean right = helper(node.right,node.val,high);

        return left && right; 
    }
}