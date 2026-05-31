class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            HashSet<Character> rowSet = new HashSet<>();
            HashSet<Character> colSet = new HashSet<>();
            for(int j = 0; j < 9; j++){
                // Row check
                char rowVal = board[i][j];
                if(rowVal != '.'){
                    if(rowSet.contains(rowVal)) return false;
                    rowSet.add(rowVal);
                }
                // Column check
                char colVal = board[j][i];
                if(colVal != '.'){
                    if(colSet.contains(colVal)) return false;
                    colSet.add(colVal);
                }
            }
        }

        // Check all 3x3 boxes
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){

                HashSet<Character> boxSet = new HashSet<>();
                for(int i = 0; i < 3; i++){
                    for(int j = 0; j < 3; j++){
                        char val = board[row + i][col + j];
                        if(val == '.') continue;
                        if(boxSet.contains(val)) return false;

                        boxSet.add(val);
                    }
                }
            }
        }
        return true;
    }
}