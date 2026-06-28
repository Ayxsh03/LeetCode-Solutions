class Solution {
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) totalSum += num;
        if (totalSum % 2 != 0) return false;

        int target = totalSum / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return solve(0, target, nums, memo);
    }

    private boolean solve(int i, int target, int[] nums, Boolean[][] dp) {
        if (target == 0) return true;
        if (i == nums.length) return false;

        if (dp[i][target] != null) return dp[i][target];

        boolean notPick = solve(i + 1, target, nums, dp);
        boolean pick = false;
        if (nums[i] <= target) pick = solve(i + 1, target - nums[i], nums, dp);

        return dp[i][target] = pick || notPick;
    }
}