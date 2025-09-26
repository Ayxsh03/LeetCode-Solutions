class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int ans[] = new int[n - k + 1];
        Deque<Integer> dq = new LinkedList<>();

        for(int i = 0; i < n; i++){
            // Remove elements outside the current window
            if(!dq.isEmpty() && dq.peekFirst() < i - k + 1){
                dq.pollFirst();
            }
            // Remove elements smaller than the current element from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }   
            // Add the current element index to the deque
            dq.offerLast(i);

            if (i >= k - 1) {
                ans[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return ans;
    }
}