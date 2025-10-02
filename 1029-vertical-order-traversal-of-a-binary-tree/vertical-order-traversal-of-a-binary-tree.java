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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, Map<Integer, List<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);

        List<List<Integer>> ans = new ArrayList<>();
        for (Map<Integer, List<Integer>> levelMap : map.values()) {
            List<Integer> level = new ArrayList<>();
            for (List<Integer> nodeList : levelMap.values()) {
                Collections.sort(nodeList); // Sort values at each (x, y) level
                level.addAll(nodeList);
            }
            ans.add(level);
        }
        return ans;
    }

    void dfs(TreeNode root, int col, int level, Map<Integer, Map<Integer, List<Integer>>> map){
        if(root == null) return;
        if(!map.containsKey(col)) map.put(col, new TreeMap<>());
        if(!map.get(col).containsKey(level)) map.get(col).put(level, new ArrayList<>());
        
        map.get(col).get(level).add(root.val);
        dfs(root.left, col - 1, level + 1, map);
        dfs(root.right, col + 1, level + 1, map);
    }
}