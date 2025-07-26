class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = -1;
            }
        }

        return minSum(m-1, n-1, dp, grid);
    }
    public static int minSum(int m, int n, int[][] dp, int[][] grid) {
        if (m == 0 && n == 0) return grid[0][0];
        if (m < 0 || n < 0) return Integer.MAX_VALUE;
        if (dp[m][n] != -1) return dp[m][n];

        int left = minSum(m - 1, n, dp, grid);
        int up = minSum(m, n - 1, dp, grid);

        return dp[m][n] = Math.min(left, up) + grid[m][n];
    }
}