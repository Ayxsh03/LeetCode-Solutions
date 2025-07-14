class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int low = Integer.MAX_VALUE;
        int high = 0;
        for(int weight: weights){
            high += weight;
            low = Math.min(low, weight);
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
        int sum = 0, total = 0;
        for (int weight : weights) {
            if(weight > capacity) return false;
            sum += weight;
            if(sum > capacity){
                total++;
                sum = weight;
            }
        }
        total++;
        return total <= days;
    }
}