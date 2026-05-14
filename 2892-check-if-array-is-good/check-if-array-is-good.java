class Solution {
    public boolean isGood(int[] nums) {
        int[] arr = getMaxAndCount(nums);

        int max = arr[0];
        int count = arr[1];
        int n = nums.length;

        // size should be max + 1
        // max should appear twice
        if(n != max + 1 || count != 2) return false;
        int[] freq = new int[max + 1];
        
        for(int num : nums){
            // invalid number
            if(num < 1 || num > max) return false;
            freq[num]++;
        }

        // 1 to max-1 should appear once
        for(int i = 1; i < max; i++){
            if(freq[i] != 1) return false;
        }

        // max should appear twice
        return freq[max] == 2;
    }

    public int[] getMaxAndCount(int[] arr){
        int max = arr[0];
        int count = 1;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
                count = 1;
            }
            else if(arr[i] == max) count++;
        }
        return new int[]{max, count};
    }
}