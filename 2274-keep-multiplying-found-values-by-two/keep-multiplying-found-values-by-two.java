class Solution {
    public int findFinalValue(int[] nums, int original) {
        Arrays.sort(nums);
        while(true){
            if(bS(nums, original)){
                original *= 2;
            }
            else return original;
        }
    }

    public boolean bS(int[] arr, int target){
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){
            int mid = (low + high) / 2;
            if(arr[mid] == target) return true;
            else if(arr[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }   
}