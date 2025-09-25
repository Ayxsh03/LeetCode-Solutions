class Solution {
    public boolean isBalanced(TreeNode root) {
        return dfs(root) != -1;
    }

    private int dfs(TreeNode node) {
        if (node == null) return 0;

        int left = dfs(node.left);
        if (left == -1) return -1; // left not balanced

        int right = dfs(node.right);
        if (right == -1) return -1; // right not balanced

        if (Math.abs(left - right) > 1) return -1; // current not balanced

        return Math.max(left, right) + 1; // return height
    }
}