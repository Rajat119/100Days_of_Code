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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length-1);
    }

    public TreeNode build(int[] nums, int start, int end) {
        if (start == end) {
            return new TreeNode(nums[start]);
        }

        if (end < start) {
            return null;
        }

        int mid = (start + end) / 2;
        TreeNode t = new TreeNode(nums[mid]);
        t.left = build(nums, start, mid - 1);
        t.right = build(nums, mid + 1, end);
        return t;
    }
}