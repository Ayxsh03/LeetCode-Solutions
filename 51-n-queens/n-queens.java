class Solution {
    void nQueens(int col, char[][] board,  List<List<String>> list, int n){
        if(col == n){
            list.add(construct(board));
            return;
        }
        for(int row = 0; row < n; row++){
            if(isValid(row, col, board)){
                board[row][col] = 'Q';
                nQueens(col + 1, board, list, n);
                board[row][col] = '.'; //Backtrack
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++) board[i][j] = '.';
        }
        nQueens(0, board, list, n);
        return list;
    }

    boolean isValid(int row, int col, char[][] board){
        int r = row, c = col;
        while(r >= 0 && c >= 0){
            if(board[r][c] == 'Q') return false;
            r--; c--;
        }

        r = row; c = col;
        while(c >= 0){
            if(board[r][c] == 'Q') return false;
            c--;
        }

        r = row; c = col;
        while(r < board.length && c >= 0){
            if(board[r][c] == 'Q') return false;
            r++; c--;
        }

        return true;
    }

    static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
}