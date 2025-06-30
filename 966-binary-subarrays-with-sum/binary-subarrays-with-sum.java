class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int n = nums.length, count = 0;
        int l = 0, r = 0;
        int sum = 0;
        while(r < n){
            sum += nums[r];
            if(sum == goal) count++;
            if(sum > goal){
                l++;
                sum = 0;
                r = l;
                continue;
            }
            if(r == n-1){
                l++;
                r=l;
                sum = 0;
                continue;
            }
            r++;
        }
        return count;
    }
}