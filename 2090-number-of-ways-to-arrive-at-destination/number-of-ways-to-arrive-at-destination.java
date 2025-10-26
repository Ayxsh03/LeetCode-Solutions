class Solution {
    static final long MOD = 1_000_000_007L;

    public int countPaths(int n, int[][] roads) {
        List<List<long[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : roads) {
            int u = r[0], v = r[1], w = r[2];
            adj.get(u).add(new long[]{v, w});
            adj.get(v).add(new long[]{u, w});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq =
            new PriorityQueue<>((a, b) -> Long.compare(a[0], b[0])); // [dist, node]
        pq.add(new long[]{0L, 0L});

        while (!pq.isEmpty()) {
            long[] cur = pq.poll();
            long d = cur[0], node = cur[1];
            if (d > dist[(int) node]) continue; 

            for (long[] e : adj.get((int) node)) {
                int v = (int) e[0];
                long w = e[1];
                long new_d = d + w;

                if (new_d < dist[v]) {
                    dist[v] = new_d;
                    ways[v] = ways[(int) node];
                    pq.add(new long[]{new_d, v});
                } else if (new_d == dist[v]) {
                    ways[v] = (ways[v] + ways[(int) node]) % MOD;
                }
            }
        }
        return (int) (ways[n - 1] % MOD);
    }
}
