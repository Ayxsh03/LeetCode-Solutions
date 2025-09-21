class Solution {
    public int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) return 0;
        int n = heights.length;
        
        int maxArea = 0;
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i < n; i++) {
            while(!st.isEmpty() && heights[i] < heights[st.peek()]){
                int element = st.pop();
                int nse = i; // popped element's nse is i (current)
                int pse = st.isEmpty() ? -1 : st.peek(); //popped elements pse is stack's top
                maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){ // no nse for some elements which are in stack
            int nse = n; // Hypothetical NSE N
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }
}