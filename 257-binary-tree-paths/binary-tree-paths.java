class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;
        dfs(root, "", result);
        return result;
    }
    void dfs(TreeNode node, String path, List<String> result) {
        if (node == null) return;
        
        path += node.val;

        if(node.left == null && node.right == null){
            result.add(path);
            return;
        }
        path += "->";
        dfs(node.left, path, result);
        dfs(node.right, path, result);
    }
}