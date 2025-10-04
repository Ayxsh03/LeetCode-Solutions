class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int area = 0;
        while(left < right){
            int current = Math.min(height[left], height[right]);
            area = Math.max(area, current * (right - left));
            while (left < right && height[left] <= current){
                left++;
            }
            while (left < right && height[right] <= current){
                right--;
            }
        }
        return area;
    }
}