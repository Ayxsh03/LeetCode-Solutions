class Solution {
    public boolean search(int[] arr, int target) {
        int n=arr.length;
        int low=0, high=n-1;
        while(low<=high){
            int mid = low + (high - low)/2;
            if(target == arr[mid]) return true;

            //Edge Case when arr[low] == arr[mid] == arr[high]
            if(arr[low] == arr[mid] && arr[mid] == arr[high]){
                low++;
                high--;
            }
            else if(arr[low] <= arr[mid]){ //left part sorted
                if(arr[low] <= target && target <= arr[mid]){ //target is present
                    high = mid-1; //discard right part
                }
                else low = mid+1;  //discard left part when target is not present
            }
            else{ //right part sorted
                if(arr[mid] <= target && target <= arr[high]){ //target is present
                    low = mid+1;
                }
                else high = mid-1;
            }
        }
        return false;
    }
}