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
    int counter;
    int target;
    public int kthSmallest(TreeNode root, int k) {
        counter = 1;
        inorder(root, k);
        return target;
    }
    private boolean inorder(TreeNode root, int k) {
        if (root == null) {
            return false;
        }

        if (inorder(root.left, k)) {
            return true;
        }
        if (counter == k) {
            target = root.val;
            return true;
        }
        counter++;
        
        return inorder(root.right, k);
    }
}