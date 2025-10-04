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
        List<TreeNode> path1 = new ArrayList<>();
        List<TreeNode> path2 = new ArrayList<>();
        if (!findPath(root, p, path1) || !findPath(root, q, path2)) return null;

        int m = Math.min(path1.size(), path2.size());
        TreeNode ans = null;
        for (int i = 0; i < m; i++) {
            if (path1.get(i) == path2.get(i)) ans = path1.get(i);
            else break;
        }
        return ans;
    }
    
    private static boolean findPath(TreeNode root, TreeNode target, List<TreeNode> path) {
        if (root == null) return false;
        path.add(root);
        if (root == target) return true;
        if (findPath(root.left, target, path) || findPath(root.right, target, path)) return true;
        path.remove(path.size() - 1);
        return false;
    }
}