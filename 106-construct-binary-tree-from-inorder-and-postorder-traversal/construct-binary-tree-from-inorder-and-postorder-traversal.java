class Solution {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        int inStart = 0, inEnd = n - 1;
        int postStart = 0, postEnd = n - 1;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++) map.put(inorder[i], i);

        return solve(inorder, postorder, 0, n - 1, 0, n - 1, map);
    }

    TreeNode solve(int[] inorder, int[] postorder, int inStart, 
    int inEnd, int postStart, int postEnd, Map<Integer, Integer> map){
        if(inStart > inEnd || postStart > postEnd) return null;

        int val = postorder[postEnd];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);

        int leftSize = i - inStart;
        int rightSize = inEnd - i;

        root.left = solve(inorder, postorder, inStart, i - 1, postStart, postStart + leftSize - 1, map);
        root.right = solve(inorder, postorder, i + 1, inEnd, postEnd - rightSize, postEnd - 1, map);
        
        return root;
    }

}