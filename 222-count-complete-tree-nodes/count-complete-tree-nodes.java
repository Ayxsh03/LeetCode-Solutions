class Solution {
    public int countNodes(TreeNode root){
        return dfs(root, 0);
    }

    int dfs(TreeNode node, int count) {
        if (node == null) return count;
        count++;
        count = dfs(node.left, count);
        count = dfs(node.right, count);
        return count;
    }
}
