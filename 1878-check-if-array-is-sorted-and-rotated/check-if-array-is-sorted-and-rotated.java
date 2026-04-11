class Solution {
    public boolean check(int[] nums) {
        boolean isSorted = false;
        int breaks = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i - 1] > nums[i]) breaks++;
        }
        if(nums[0] < nums[nums.length - 1]) breaks++;

        if(breaks >= 2) return false;
        return true;
    }
}