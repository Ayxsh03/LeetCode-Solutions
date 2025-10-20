class Solution {
    public boolean isBipartite(int[][] graph) {
        int V = graph.length;
        int[] color = new int[V]; // 0: uncolored, 1: color 1, 2: color 2

        for (int i = 0; i < V; i++) {
            if (color[i] == 0) { // If the node is uncolored
                if (!check(i, graph, color)) return false;
            }
        }
        return true;
    }

    public boolean check(int start, int[][] graph, int[] color) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        color[start] = 1; // Assign the first color

        while (!q.isEmpty()) {
            int node = q.poll();
            for (int neighbor : graph[node]) {
                if (color[neighbor] == 0) { // If the neighbor is uncolored
                    color[neighbor] = (color[node] == 1) ? 2 : 1; // Assign opposite color
                    q.add(neighbor);
                } else if (color[neighbor] == color[node]) { // If neighbor has the same color
                    return false;
                }
            }
        }
        return true;
    }
}