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
    public int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum = 0;
        dfs(root);
        return sum;
    }

    public void dfs(TreeNode node){
        if(node.left != null){
            TreeNode child = node.left;
            if(isLeaf(child)) sum += child.val;
            dfs(node.left);
        }
        if(node.right != null) dfs(node.right);
        return;
    }
    
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}