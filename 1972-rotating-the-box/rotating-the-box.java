class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Apply gravity row by row
        for (int row = 0; row < m; row++) {

            // Rightmost position where the next stone can fall
            int empty = n - 1;

            // Traverse from right to left
            for (int col = n - 1; col >= 0; col--) {

                // Obstacle blocks stones
                // So next valid landing position becomes just before obstacle
                if (boxGrid[row][col] == '*') {

                    empty = col - 1;
                }

                // Found a stone
                else if (boxGrid[row][col] == '#') {

                    // Remove stone from current position
                    boxGrid[row][col] = '.';

                    // Drop stone at the furthest possible right position
                    boxGrid[row][empty] = '#';

                    // Next stone must land one position before
                    empty--;
                }
            }
        }

        // Rotate box 90 degree clockwise
        return rotate(boxGrid);
    }

    public char[][] rotate(char[][] matrix) {

        int m = matrix.length;
        int n = matrix[0].length;

        // Rotated matrix dimensions become n x m
        char[][] rotated = new char[n][m];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Move current cell to its rotated position
                rotated[j][m - 1 - i] = matrix[i][j];
            }
        }
        return rotated;
    }
}