class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return solve(0, n, memo);
    }

    int solve(int i, int n, int[] memo) {
        // Forward thinking
        if (i == n) return 1;
        if (i > n) return 0;

        if(memo[i] != -1) return memo[i];
        return memo[i] = solve(i + 1, n, memo) + solve(i + 2, n, memo);
    } 
}