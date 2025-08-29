class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] path : paths) {
            int u = path[0] - 1;
            int v = path[1] - 1;
            adj[u].add(v);
            adj[v].add(u);
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5];
            for (int neighbor : adj[i]) {
                if (ans[neighbor] != 0) {
                    used[ans[neighbor]] = true; 
                }
            }
            for (int type = 1; type <= 4; type++) {
                if (!used[type]) {
                    ans[i] = type;
                    break;
                }
            }
        }
        return ans;
    }
}