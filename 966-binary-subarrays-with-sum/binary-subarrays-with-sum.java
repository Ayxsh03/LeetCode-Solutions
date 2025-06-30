class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return num(nums , goal) - num(nums , goal - 1);
    }

    int num(int[] nums , int goal){
        if(goal < 0) return 0; //if goal =0, goal -1 = -1;
        int l = 0, r = 0;
        int sum = 0, count = 0;
        while( r < nums.length){
            sum += nums[r];
            while(sum > goal){
                sum -= nums[l];
                l++;
            }
            count  += ( r - l  + 1);
            r++;
        }
        return count;
    } 
}