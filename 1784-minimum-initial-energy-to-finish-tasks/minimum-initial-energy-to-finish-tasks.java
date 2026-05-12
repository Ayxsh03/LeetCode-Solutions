class Solution {
    public int minimumEffort(int[][] tasks) {
        Arrays.sort(tasks, (a, b) ->
            (b[1] - b[0]) - (a[1] - a[0])
        );
        int low = 0, high = 0;
        for(int[] t : tasks){
            high = high + t[1];
        }
        int ans = high;
        while(low <= high){
            int mid = low + (high - low)/2;

            if(isPossible(tasks, mid)){
                ans = mid;
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return ans;
    }

    public boolean isPossible(int[][] tasks, int initial){
        int energy = initial;
        for(int[] t : tasks){
            int actual = t[0];
            int min = t[1];
            if(energy < min) return false;

            energy = energy - actual;
        }
        return true;
    }
}