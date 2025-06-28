class Solution {
    public int[] searchRange(int[] nums, int target) {
        int lower=lowerbound(nums, target);
        if(lower==nums.length || nums[lower]!=target){
            return new int[]{-1,-1};
        }
        else{
            return new int[]{lower,upperbound(nums, target)-1};
        }
    }
    public int lowerbound(int[] nums, int target){
        int i=0, j=nums.length-1;
        int lowerbound=nums.length;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]>=target){
                lowerbound=mid;
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return lowerbound;
    }
    public int upperbound(int[] nums, int target){
        int i=0, j=nums.length-1;
        int upperbound=nums.length;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]>target){
                upperbound=mid;
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return upperbound;
    }
}