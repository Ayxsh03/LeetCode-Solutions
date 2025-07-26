class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        
        int[][] dp = new int[n][n];
        // Base case: first row is same as matrix
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int up = dp[i - 1][j];
                int left = (j > 0) ? dp[i - 1][j - 1] : Integer.MAX_VALUE;
                int right = (j < n - 1) ? dp[i - 1][j + 1] : Integer.MAX_VALUE;

                dp[i][j] = Math.min(up, Math.min(left, right)) + matrix[i][j];
            }
        }

        // Return the min of last row
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            min = Math.min(min, dp[n - 1][j]);
        }
        return min;
    }
}