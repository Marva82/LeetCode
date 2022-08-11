/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        TreeNode curr = root;
        int pVal = p.val;
        int qVal = q.val;
        
        while(curr != null) {
            int currVal = curr.val;
            
            if(pVal > currVal && qVal > currVal) {
                curr = curr.right;
            } else if (pVal < currVal && qVal < currVal) {
                curr = curr.left;
            } else {
                return curr;
            }
        }
        return null;
        
    }
}