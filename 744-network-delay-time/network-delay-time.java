class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Build adjacency list (0-indexed)
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int i = 0; i < times.length; i++) {
            int u = times[i][0] - 1;
            int v = times[i][1] - 1;
            int w = times[i][2];
            adj.get(u).add(new int[]{v, w});
        }

        final int INF = (int) 1e9;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        int src = k - 1;
        dist[src] = 0;

        // Min-heap on distance: store as {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1];
            if (d > dist[u]) continue; // stale

            for (int[] edge : adj.get(u)) {
                int v = edge[0], w = edge[1];
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new int[]{dist[v], v});
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}
