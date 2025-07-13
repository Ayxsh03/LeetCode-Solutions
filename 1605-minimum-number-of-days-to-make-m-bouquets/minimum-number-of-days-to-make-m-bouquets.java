class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(m * k > n) return -1;

        int low = 1, high = 1, ans = -1;

        for(int i = 0; i < n; i++){
            high = Math.max(high, bloomDay[i]);
            low = Math.min(low, bloomDay[i]);
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(bloomDay, mid, m, k)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    public static boolean isValid(int[] arr, int day, int m, int k) {
        int n = arr.length; 
        int count = 0;
        int bouquets = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] <= day) count++;
            else {
                bouquets += (int)(count / k);
                count = 0;
            }
        }
        bouquets += (int)(count / k);
        return bouquets >= m;
    }

}