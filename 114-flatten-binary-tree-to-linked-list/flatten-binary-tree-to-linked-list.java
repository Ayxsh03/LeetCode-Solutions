class Solution {
    void preorder(TreeNode root, List<Integer> nodes) {
        if (root == null) return;

        nodes.add(root.val);
        preorder(root.left, nodes);
        preorder(root.right, nodes);
    }

    public void flatten(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        preorder(root, nodes);

        if(nodes.isEmpty()) return;

        TreeNode temp = root;

        for (int i = 1; i < nodes.size(); i++) {
            TreeNode newNode = new TreeNode(nodes.get(i));
            temp.left = null;
            temp.right = newNode;
            temp = newNode;
        }
    }
}