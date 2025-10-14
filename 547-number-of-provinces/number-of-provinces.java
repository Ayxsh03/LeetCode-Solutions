class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        int[] visited = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                count++;
                dfs(i, visited, isConnected);
            }
        }
        return count;
    }

    void dfs(int node, int[] visited, int[][] matrix){
        visited[node] = 1;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[node][i] == 1 && visited[i] == 0) {
                dfs(i, visited, matrix);
            }
        }
    }
}