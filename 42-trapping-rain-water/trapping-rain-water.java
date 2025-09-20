class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];

        maxLeft[0] = 0;
        for (int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(maxLeft[i - 1], height[i - 1]);
        }

        maxRight[n - 1] = 0;
        for (int i = n - 2; i >= 0; i--) {
            maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
        }

        int water = 0;
        for (int i = 0; i < n; i++) {
            if(height[i] < maxLeft[i] && height[i] < maxRight[i]){
                water += Math.min(maxLeft[i], maxRight[i]) - height[i];
            }
        }
        return water;
    }
}