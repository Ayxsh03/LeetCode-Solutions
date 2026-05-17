class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        // Prefix Products array
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i - 1] * nums[i - 1];
        }

        // Multiply suffix products
        int suffix = 1;
        for(int i = n - 1; i >= 0; i--){
            ans[i] = ans[i] * suffix;
            //Updating Suffix Product
            suffix = suffix * nums[i];
        }
        return ans;
    }
}