class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int lh = left_height(root);
        int rh = right_height(root);

        if (lh == rh) return (1 << lh) - 1;  // (2^lh - 1)
        else return 1 + countNodes(root.left) + countNodes(root.right);
    }

    int left_height(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.left;
        }
        return count;
    }
    int right_height(TreeNode root) {
        int count = 0;
        while (root != null) {
            count++;
            root = root.right;
        }
        return count;
    }
}