class Solution {
    public void solveSudoku(char[][] board) {
        sudoku(0, 0, board);
    }

    private boolean sudoku(int row, int col, char[][] board) {
        if(row == 8 && col == 9) return true;

        if(col == 9) return sudoku(row + 1, 0, board);

        if(board[row][col] != '.') return sudoku(row, col + 1, board);

        for(int i = 1; i <= 9; i++){
            if(isPossible(row, col, i, board)){
                board[row][col] = (char)(i + '0');
                if (sudoku(row, col + 1, board)) return true;
                board[row][col] = '.';
            }
        }
        return false;
    }

    private boolean isPossible(int row, int col, int num, char[][] board) {
        char ch = (char)(num + '0');
        for(int i = 0; i < 9; i++){
            if(board[i][col] == ch || board[row][i] == ch)
                return false;
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for(int i = startRow; i < startRow + 3; i++){
            for(int j = startCol; j < startCol + 3; j++){
                if(board[i][j] == ch)
                    return false;
            }
        }
        return true;
    }
}