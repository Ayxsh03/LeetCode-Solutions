class Solution {
    public int idx = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return solve(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode solve(int[] preorder, int[] inorder, int start, int end) {
        if (start > end) return null;

        int val = preorder[idx++];
        TreeNode root = new TreeNode(val);

        int i = find(inorder, val, start, end); // linear search
        root.left = solve(preorder, inorder, start, i - 1);
        root.right = solve(preorder, inorder, i + 1, end);

        return root;
    }

    private int find(int[] inorder, int val, int start, int end) {
        for (int i = start; i <= end; i++) {
            if (inorder[i] == val) return i;
        }
        return -1;
    }
}