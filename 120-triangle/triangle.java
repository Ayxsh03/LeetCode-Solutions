class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        
        int dp[][] = new int[m][m];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        int min = Integer.MAX_VALUE;
        for(int j = 0; j < m; j++){
            min = Math.min(min , minSum(m - 1, j, dp, triangle));
        }
        return min;
    }
    public static int minSum(int m, int n, int[][] dp, List<List<Integer>> grid) {
        if (m == 0 && n == 0) return grid.get(0).get(0);
        if (m < 0 || n < 0 || n > m) return Integer.MAX_VALUE;
        if (dp[m][n] != -1) return dp[m][n];

        int diagonal = minSum(m - 1, n - 1, dp, grid);
        int up = minSum(m - 1, n, dp, grid);

        return dp[m][n] = Math.min(diagonal, up) + grid.get(m).get(n);
    }
}