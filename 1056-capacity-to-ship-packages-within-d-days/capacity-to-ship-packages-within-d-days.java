class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = 0, high = 0;
        for(int weight: weights){
            high += weight; // Max must be if all is shipped in 1 day
            low = Math.max(low, weight); 
            //Min capacity must be max weights
        }
        int ans = 0;
        while (low <= high){
            int mid = low + (high - low) / 2;
            if (isValid(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    private boolean isValid(int[] weights, int capacity, int days){
        int sum = 0, total = 1; //day 1
        for (int weight : weights) {
            sum += weight;
            if(sum > capacity){
                total++;
                sum = weight;
            }
        }
        return total <= days;
    }
}