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
        List<List<Integer>>list=new ArrayList<>();
        if(root==null){
           return list;
       }
        Queue<TreeNode>queue=new LinkedList<>();
        queue.add(root);
        int level=0;
        while(!queue.isEmpty()){
            int len=queue.size();
            List<Integer>levellist=new ArrayList<>();
            for(int i=0;i<len;i++){
            TreeNode temp=queue.poll();
            if(temp.left!=null)
                queue.add(temp.left);
            
            if(temp.right!=null)
                queue.add(temp.right);
            
            if(level%2==0)
                levellist.add(temp.val);
            else
                levellist.add(0,temp.val);
        }
        level++;
        list.add(levellist);
        }
        return list;
    }
}