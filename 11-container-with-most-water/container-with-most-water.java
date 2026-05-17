class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int n = height.length;

        int i = 0;
        int j = n - 1;

        while(i < j){
            int breadth = (j - i);
            int minHeight = Math.min(height[i] ,height[j]);
            maxArea = Math.max(breadth * minHeight, maxArea);
            if(minHeight == height[i]) i++;
            else j--;
        }
        return maxArea;
    }
}