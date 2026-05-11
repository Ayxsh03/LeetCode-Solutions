class Solution {
    public int[] separateDigits(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = nums.length - 1; i >= 0; i--){
            while(nums[i] > 0){
                arr.add(nums[i] % 10);
                nums[i] = nums[i]/10; 
            }
        }
        int n = arr.size();
        int[] ans = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = arr.get(n - i - 1);
        }
        return ans;
    }
}