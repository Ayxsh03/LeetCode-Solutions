class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int F0 = 0;

        for(int i = 0; i < n; i++){
            sum += nums[i];
            F0 += nums[i] * i;
        }
        int curr = F0;
        int max = curr;

        for(int k = 1; k < n; k++){
            curr = curr + sum - n * nums[n - k];
            max = Math.max(curr , max);
        }
        return max;
    }
}