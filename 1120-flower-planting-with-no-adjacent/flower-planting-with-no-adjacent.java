class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] p : paths) {
            int a = p[0] - 1, b = p[1] - 1;  // make 0-indexed
            g[a].add(b);
            g[b].add(a);
        }

        int[] color = new int[n]; // 0 means uncolored
        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5]; // indices 1..4
            for (int nei : g[i]) used[color[nei]] = true; // 0 is fine
            for (int c = 1; c <= 4; c++) if (!used[c]) { color[i] = c; break; }
        }
        return color;
    }
}
