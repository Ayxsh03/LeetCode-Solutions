class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<Pair> queue = new LinkedList<>();

        int freshCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }
        if (freshCount == 0) return 0;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int minutes = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                Pair current = queue.poll();
                int r = current.x;
                int c = current.y;
                for (int k = 0; k < 4; k++) {
                    int x = r + dx[k];
                    int y = c + dy[k];
                    if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshCount--;
                        queue.add(new Pair(x, y));
                        rotted = true;
                    }
                }
            }
            // Increment time if any orange rotted in this level
            if (rotted) minutes++;
        }
        return freshCount == 0 ? minutes : -1;
    }
    public static class Pair {
        int x, y;
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}