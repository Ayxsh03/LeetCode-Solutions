class Solution {
    public int amountOfTime(TreeNode root, int start) {
        if (root == null) return 0;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        TreeNode star = dfs(root, map, start);
        if (star == null) return 0;

        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> vis = new HashSet<>();
        q.add(star);
        vis.add(star);

        int minutes = -1;
        while (!q.isEmpty()) {
            int size = q.size();
            minutes++;
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.remove();

                if (curr.left  != null && vis.add(curr.left))  q.add(curr.left);
                if (curr.right != null && vis.add(curr.right)) q.add(curr.right);

                TreeNode parent = map.get(curr);
                if (parent != null && vis.add(parent)) q.add(parent);
            }
        }
        return minutes;
    }

    // Build parent map and return the node whose val == start
    private TreeNode dfs(TreeNode node, Map<TreeNode, TreeNode> map, int start) {
        if (node == null) return null;

        if (node.left != null)  map.put(node.left, node);
        if (node.right != null) map.put(node.right, node);

        if (node.val == start) return node;

        TreeNode left = dfs(node.left, map, start);
        if (left != null) return left;
        return dfs(node.right, map, start);
    }
}
