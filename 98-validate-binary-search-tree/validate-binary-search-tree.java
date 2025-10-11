class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }
    public boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if(root==null) return true;
        if((max != null && root.val >= max) || (min != null &&root.val <= min)) return false;
        return isValidBST(root.left, min, root.val)
            && isValidBST(root.right, root.val, max);    
    }
}