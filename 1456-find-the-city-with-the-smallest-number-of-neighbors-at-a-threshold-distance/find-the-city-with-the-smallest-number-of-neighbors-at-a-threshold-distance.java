class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        int cost[][] = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) cost[i][j]=0;
                else cost[i][j]=(int) 1e9;
            }
        }
        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            cost[u][v] = wt;
            cost[v][u] = wt;
        }
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                for(int k = 0; k < n; k++){
                    cost[j][k] = Math.min(cost[j][k], cost[j][i] + cost[i][k]);
                }
            }
        }
        int store = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0; i < n; i++){
            int val=0;
            for(int j=0; j<n; j++){
                if(i==j) continue;
                if(cost[i][j]<=distanceThreshold){
                    val++;
                }
            }
            if(val <= store){
                store = val;
                ans = i;
            }
        }
        return ans;
    }
}