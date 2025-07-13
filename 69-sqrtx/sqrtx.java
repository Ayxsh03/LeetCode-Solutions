class Solution {
    public int mySqrt(int x) {
        int ans = 0;
        int low = 1, high = x;
        while(low <= high){
            int mid = low + (high - low)/2;
            if (mid <= x / mid){
                //mid * mid <= x TO mid <= x / mid, avoid multiplying large values and prevent overflow.
                ans = mid;             
                low = mid + 1;
            }
            else high=mid - 1;
        }
        return ans;
    }
}