class Solution {
    static class Pair{
        TreeNode node;
        int index;
        Pair(TreeNode node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        
        int maxWidth = 0;
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(root, 0));

        while(!q.isEmpty()){
            int size = q.size();
            int left = q.peekFirst().index, min = left; // Normalize
            int right = q.peekLast().index;
            maxWidth = Math.max(right - left + 1, maxWidth); //levelwidth

            for(int i = 0; i < size; i++){
                Pair p = q.pollFirst();
                TreeNode curr = p.node;
                int index = p.index - min; // Normalize
                if(curr.left != null){
                    q.add(new Pair(curr.left, 2 * index + 1));
                }
                if(curr.right != null){
                    q.add(new Pair(curr.right, 2 * index + 2));
                }
            }
        }
        return maxWidth;
    }
}