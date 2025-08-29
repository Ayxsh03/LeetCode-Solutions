class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(0, word, board, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    private boolean dfs(int index, String word, char[][] board, int i, int j){
        if(index == word.length()) return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if(board[i][j] != word.charAt(index)) return false;
        if(board[i][j] == '#') return false;

        char temp = board[i][j];
        board[i][j] = '#';

        for(int k = 0; k < 4; k++){
            int new_i = i + dx[k];
            int new_j = j + dy[k];
            if(dfs(index + 1, word, board, new_i, new_j)) return true;
        }

        board[i][j] = temp;

        return false;
    }
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
}