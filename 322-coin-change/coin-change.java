import java.util.Arrays;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1); // mark uncomputed states
        }

        int ans = coinsNum(n - 1, amount, coins, dp);
        return (ans >= Integer.MAX_VALUE) ? -1 : ans;
    }

    private int coinsNum(int i, int target, int[] arr, int[][] dp) {
        if (target == 0) return 0;

        if (i == 0) {
            if (target % arr[0] == 0) return target / arr[0];
            else return Integer.MAX_VALUE;
        }

        if (dp[i][target] != -1) return dp[i][target];

        int notTake = coinsNum(i - 1, target, arr, dp);

        int take = Integer.MAX_VALUE;
        if (arr[i] <= target) {
            int sub = coinsNum(i, target - arr[i], arr, dp);
            if (sub != Integer.MAX_VALUE) {
                take = 1 + sub;
            }
        }
        return dp[i][target] = Math.min(take, notTake);
    }
}