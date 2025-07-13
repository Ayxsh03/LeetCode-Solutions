class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, ans = 1, high = 1;
        for(int i = 0; i < piles.length; i++) high = Math.max(high,piles[i]);
        while(low <= high){
            int mid = low + (high - low)/2;
            if(isValid(mid,piles,h)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }
    boolean isValid(int speed, int[] arr, int h){
        int time = 0;
        for(int pile: arr){
            time += (pile + speed - 1) / speed;
        //  time += (int) Math.ceil((double)pile / speed) 
            if (time > h) return false;
        } 
        return time <= h;
    }
}