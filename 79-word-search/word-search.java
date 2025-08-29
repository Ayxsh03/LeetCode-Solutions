class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(0, word, board, isVisited, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int index, String word, char[][] board, boolean[][] isVisited, int i, int j) {
        if (index == word.length()) return true;

        // Bounds check + visited check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || isVisited[i][j]) {
            return false;
        }

        if (board[i][j] != word.charAt(index)) return false;

        isVisited[i][j] = true;

        // Explore all 4 directions
        boolean found = dfs(index + 1, word, board, isVisited, i - 1, j) ||  // up
                        dfs(index + 1, word, board, isVisited, i + 1, j) ||  // down
                        dfs(index + 1, word, board, isVisited, i, j - 1) ||  // left
                        dfs(index + 1, word, board, isVisited, i, j + 1);    // right

        // Backtrack
        isVisited[i][j] = false;

        return found;
    }
}