class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans = new ArrayList<>();
        if (root == null || target == null) return ans;

        Map<TreeNode, TreeNode> map = new HashMap<>();
        dfs(root, map);

        // BFS from target
        Queue<TreeNode> q = new ArrayDeque<>();
        Set<TreeNode> vis = new HashSet<>(); //given all node.val unique
        q.add(target);
        vis.add(target);
        int level = 0;

        while(!q.isEmpty()){
            int size = q.size();
            if(level == k){
                for(TreeNode n : q) ans.add(n.val);
                break;
            }
            for (int i = 0; i < size; i++){
                TreeNode curr = q.remove();
                // push if !vis.contains(node) -> q.(node) vis.add(node)
                // vis.add(node) return true only if node wasn’t already in the set
                if(curr.left != null && vis.add(curr.left))  q.add(curr.left);
                if(curr.right != null && vis.add(curr.right)) q.add(curr.right);
                TreeNode parent = map.get(curr);
                if(parent != null && vis.add(parent)) q.add(parent);
            }
            level++;
        }
        return ans;
    }

    void dfs(TreeNode node, Map<TreeNode, TreeNode> map){
        if(node == null) return;
        if(node.left != null) map.put(node.left, node); //child , parent
        dfs(node.left, map);
        if(node.right != null) map.put(node.right, node); //child , parent
        dfs(node.right, map);
    }
}