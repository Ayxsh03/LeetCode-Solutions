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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        list = postorderTraverse(root,list);
        return list;
    }

    List<Integer> postorderTraverse(TreeNode root,List<Integer> list) {
        if(root==null) return list;
        postorderTraverse(root.left,list);
        postorderTraverse(root.right,list);
        list.add(root.val);
        return list;
    }
}