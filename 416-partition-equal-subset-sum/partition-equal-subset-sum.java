class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;

        int totalSum = 0;
        for(int i = 0; i < n; i++) totalSum += nums[i];
        int target = totalSum / 2;
        if (totalSum % 2 != 0) return false; //Cant partition odd length arr

        int dp[][] = new int[n][target + 1];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < target + 1; j++){
                dp[i][j] = -1;
            }
        }

        return f(n - 1, target, nums, dp);
    }

    boolean f(int index, int target, int[] arr, int[][] dp){
        if (target == 0) return true;
        if (index == 0) return arr[0] == target;

        if (dp[index][target] != -1)
            return dp[index][target] == 1;

        boolean notTake = f(index - 1, target, arr, dp);
        boolean take = false;
        if (arr[index] <= target)
            take = f(index - 1, target - arr[index], arr, dp);

        dp[index][target] = (take || notTake) ? 1 : 0;
        return dp[index][target] == 1;
    }
}