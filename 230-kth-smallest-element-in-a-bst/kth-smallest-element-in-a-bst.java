class Solution {
    int count = 0;   // how many nodes we've visited in-order
    int ans = -1;    // the kth value once found

    public int kthSmallest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    void inorder(TreeNode root, int k) {
        if (root == null || ans != -1) return;

        inorder(root.left, k);

        if (++count == k) {      // visit current node
            ans = root.val;
            return;
        }

        inorder(root.right, k);
    }
}
