class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxArea = 0;
        while (left < right) {

            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);

            maxArea = Math.max(maxArea, width * currentHeight);

            // Skip heights that cannot produce a better area
            while (left < right && height[left] <= currentHeight) {
                left++;
            }
            while (left < right && height[right] <= currentHeight) {
                right--;
            }
        }
        return maxArea;
    }
}