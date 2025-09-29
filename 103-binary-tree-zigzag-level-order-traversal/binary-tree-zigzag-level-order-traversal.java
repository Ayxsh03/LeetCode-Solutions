/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        //Direction flag: true for L -> R, false for R -> L
        boolean flag = true;
        while(!q.isEmpty()){
            List<Integer> sublist = new ArrayList<>();
            int levelsize = q.size();
            for(int i=0; i<levelsize; i++){
                TreeNode current = q.poll(); 
                sublist.add(current.val);
                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);
            }
            if(!flag) Collections.reverse(sublist);
            ans.add(sublist);
            flag =! flag;
        }
        return ans;
    }
}