class Solution {
    public int[] productExceptSelf(int[] nums) {
        int count0 = 0;
        int product = 1;
        int nonZeroProduct = 1;

        for(int num : nums){
            product *= num;
            if(num == 0) count0++;
            else nonZeroProduct *= num;
        }

        int[] ans = new int[nums.length];
        if(count0 > 1) return ans;

        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0) ans[i] = nonZeroProduct;
            else ans[i] = product / nums[i];
        }
        return ans;
    }
}