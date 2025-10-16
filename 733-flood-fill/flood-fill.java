class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int initial = image[sr][sc];
        if (initial == color) return image;
        
        dfs(sr, sc, image, color, initial);
        return image;
    }

    private void dfs(int row, int col, int[][] image, int color, int initial) {
        image[row][col] = color;
        int[] deltaRow = {-1, 0, 1, 0};
        int[] deltaCol = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int newRow = row + deltaRow[i];
            int newCol = col + deltaCol[i];
            if (isValid(newRow, newCol, image, initial)) {
                dfs(newRow, newCol, image, color, initial);
            }
        }
    }

    private boolean isValid(int row, int col, int[][] image, int initial) {
        int m = image.length;
        int n = image[0].length;
        return row >= 0 && col >= 0 && row < m && col < n && image[row][col] == initial;
    }
}