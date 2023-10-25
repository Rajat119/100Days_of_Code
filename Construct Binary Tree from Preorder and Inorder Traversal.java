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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      // build the hashmap for in order index
    HashMap<Integer, Integer> map = new HashMap<>();
    for(int i =0 ; i < inorder.length; i++){
        map.put(inorder[i],i);
    }
    
    // create and call recurrsive function to build root and its left and right
    return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length-1, map);
}

private TreeNode buildTree(int[] preorder, int pre_start, int pre_end, 
                            int[] inorder, int in_start, int in_end, 
                           HashMap<Integer, Integer> map){
    
    if(pre_start > pre_end || in_start > in_end) return null;
    
    // craete object for treenode with having preorder first element as root
    TreeNode root = new TreeNode(preorder[pre_start]);
    
    // get the inorder root from map from above node
    int inRoot = map.get(root.val);
    
    // now , all the left side values in in_order is left tree, so calculate the index
    int leftNodeIndex_in = inRoot - in_start;
    
    // set the left node
    root.left = buildTree(preorder, pre_start + 1, pre_start + leftNodeIndex_in,
                         inorder, in_start, inRoot - 1, map);
    
    //set the right node
    root.right = buildTree(preorder, pre_start + leftNodeIndex_in + 1, pre_end, 
                          inorder, inRoot + 1, in_end, map);
    
    //return node
    return root;
}
}