class Solution {
    public int findCircleNum(int[][] isConnected) {
        // We have a graph as a matrix
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                count++;
                dfs(i, vis, adj);
            }
        }
        return count;

    }
    public void dfs(int node, boolean[] vis, List<List<Integer>> adj) {
        vis[node] = true;
        for (int neigh : adj.get(node)) {
            if (!vis[neigh]) dfs(neigh, vis,adj);
        }
        return;
    }
}