class Solution {
    public boolean search(int[] nums, int target) {
        int pivot = 0;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i]  > nums[i+1]){
                pivot = i+1;
                break;
            }
        }
        boolean x = binarySearch(nums,0,pivot-1, target);
        boolean y = binarySearch(nums,pivot,nums.length-1, target);
        return x||y ;
    }

    public boolean binarySearch(int[] nums, int i, int j, int target) {
        while(i<=j){
            int mid=i+(j-i)/2;
            if(target==nums[mid]) return true;
            else if(target>nums[mid]) i=mid+1;
            else j=mid-1;
        }
        return false;
    }
}