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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxDepth(root);
        return max;
    }

    public int maxDepth(TreeNode root){
        if(root == null) return 0;

        int left = Math.max(0, maxDepth(root.left));
        int right = Math.max(0, maxDepth(root.right));
        int curr = Math.max(left, right) + root.val;

        max = Math.max(max, left + right + root.val);
        
        return curr;
    }
}