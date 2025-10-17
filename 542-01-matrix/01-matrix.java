class Solution {
    public static class Pair {
        int x, y, z;
        Pair(int x, int y, int step) {
            this.x = x;
            this.y = y;
            this.z = step;
        }
    }
    
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int [][] dist = new int[m][n];

        Queue<Pair> q = new LinkedList<>();
        
        // Multiple sources BFS
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    dist[i][j] = 0;
                } else {
                    dist[i][j] = -1; // Mark as unvisited
                }
            }
        }

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int x = p.x, y = p.y, step = p.z;

            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx >= 0 && ny >= 0 && nx < m && ny < n && dist[nx][ny] == -1) {
                    q.add(new Pair(nx, ny, step + 1));
                    dist[nx][ny] = step + 1;  // Update distance when adding to the queue
                }
            }
        }
        return dist;
    }
}