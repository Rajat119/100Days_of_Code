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
    public int pathSum(TreeNode root, int targetSum) {
    return solve(root, targetSum, new ArrayList<>());
    }

    private int solve(TreeNode root, int targetSum, ArrayList<TreeNode> path) {
        if (root == null) {
            return 0;
        }

        path.add(root);

        int count = 0;
        long sum = 0;

        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).val;
            if (sum == targetSum) {
                count++;
            }
        }

        count += solve(root.left, targetSum, path);
        count += solve(root.right, targetSum, path);

        path.remove(path.size() - 1);
        return count;
    }

}