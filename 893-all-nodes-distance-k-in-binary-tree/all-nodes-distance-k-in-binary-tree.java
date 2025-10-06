/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || target == null) return ans;

        // 1) Build parent map with a DFS
        Map<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, null, parent);

        // 2) BFS from target
        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> seen = new HashSet<>();
        q.add(target);
        seen.add(target);
        int level = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            if (level == k) {                  // collect everything currently in the queue
                for (TreeNode n : q) ans.add(n.val);
                break;
            }

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.remove();

                // push neighbors if they exist and weren't visited
                if (cur.left != null && seen.add(cur.left))  q.add(cur.left);
                if (cur.right != null && seen.add(cur.right)) q.add(cur.right);
                TreeNode p = parent.get(cur);
                if (p != null && seen.add(p)) q.add(p);
            }
            level++;
        }
        return ans;
    }

    private void buildParent(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> parent) {
        if (node == null) return;
        if (par != null) parent.put(node, par);
        buildParent(node.left, node, parent);
        buildParent(node.right, node, parent);
    
    }
}