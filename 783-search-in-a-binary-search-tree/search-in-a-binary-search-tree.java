class Solution {
    public TreeNode searchBST(TreeNode root, int key) {
        while(root != null && root.val != key){
            root = (key < root.val) ? root.left : root.right;
        }
        return root;
    }
}