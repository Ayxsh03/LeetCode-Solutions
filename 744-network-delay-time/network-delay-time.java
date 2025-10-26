class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for(int i = 0; i <= n; i++){
            adj.add(new ArrayList<>());
        }
        for(int e[]:times){
            int u = e[0], v = e[1], wt = e[2];
            adj.get(u).add(new int[]{v, wt});
           
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
        int dist[] = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.add(new int[]{0, k});
        while(!pq.isEmpty()){
            int top[]= pq.poll();
            int d = top[0];
            int node = top[1];

            if(d > dist[node]) continue;
            for(int[] it:adj.get(node)){
                int neigh = it[0];
                int wt = it[1];

                if(d + wt < dist[neigh]){
                    dist[neigh] = d + wt;
                    pq.add(new int[]{dist[neigh], neigh});
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, dist[i]);
        }
        return ans;
    }
}