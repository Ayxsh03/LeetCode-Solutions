class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        if (key < root.val) root.left = deleteNode(root.left, key);
        
        else if (key > root.val) root.right = deleteNode(root.right, key);
        
        else{
            if(root.left == null && root.right == null) return null; // 0 Child
            if(root.left == null) return root.right; // 1 Child
            if(root.right == null) return root.left;
            // 2 Child
            TreeNode inorderSuccessor = minNode(root.right);
            root.val = inorderSuccessor.val;
            root.right = deleteNode(root.right, inorderSuccessor.val);
        }
        return root;
    }

    static TreeNode minNode(TreeNode node) { //inorder successor
        while(node.left != null) node = node.left;
        return node;
    }
}