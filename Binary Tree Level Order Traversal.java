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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null)
            return res;
        
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        int level = 0;
        
        while(!queue.isEmpty()) {
            //start the current level
            res.add(new ArrayList<Integer>());
            
            //number of elements in the current level
            int level_length = queue.size();
            
            for(int i = 0; i < level_length; ++i) {
                TreeNode node = queue.remove();
                
                //fulfill the current level
                res.get(level).add(node.val);
                
                //add child nodes of the current level
                //in the queue for the next level
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            //go to the next level
            level++;
        }
        return res;
        
    }
}