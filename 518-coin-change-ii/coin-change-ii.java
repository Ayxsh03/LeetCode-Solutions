class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // mark uncomputed states
        }
        int ans = coinsNum(n - 1, amount, coins, dp);
       return coinsNum(n - 1, amount, coins, dp);

    }

    private int coinsNum(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return 1;

        if (i == 0) {
            return (target % arr[0] == 0) ? 1 : 0;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = coinsNum(i - 1, target, arr, dp);

        int take = 0;
        if (arr[i] <= target) {
            take = coinsNum(i, target - arr[i], arr, dp);

        }
        return dp[i][target] = take + notTake;
    }
}