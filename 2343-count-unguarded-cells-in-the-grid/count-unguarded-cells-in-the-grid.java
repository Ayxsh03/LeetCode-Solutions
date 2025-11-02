class Solution {
    private void markGuarded(char[][] grid, int r, int c, int m, int n) {
        for (int row = r + 1; row < m; row++) {
            if (grid[row][c] == 'G' || grid[row][c] == 'W') break;
            grid[row][c] = 'V'; //visited
        }
        for (int row = r - 1; row >= 0; row--) {
            if (grid[row][c] == 'G' || grid[row][c] == 'W') break;
            grid[row][c] = 'V';
        }
        for (int col = c + 1; col < n; col++) {
            if (grid[r][col] == 'G' || grid[r][col] == 'W') break;
            grid[r][col] = 'V';
        }
        for (int col = c - 1; col >= 0; col--) {
            if (grid[r][col] == 'G' || grid[r][col] == 'W') break;
            grid[r][col] = 'V';
        }
    }
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        char[][] grid=new char[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                grid[i][j]='.';
            }
        }
        for(int[] guard: guards){
            grid[guard[0]][guard[1]]='G';
        }
        for(int[] wall: walls){
            grid[wall[0]][wall[1]]='W';
        }

        for(int[] guard: guards){
            markGuarded(grid, guard[0], guard[1], m, n);
        }
        int count=0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j]=='.') count++;
            }
        }
        return count;
    }
}