class Solution {
    public int maximalRectangle(char[][] matrix) {
        int maxArea = 0;
        int[] curr = new int[matrix[0].length];
        for(char[] arr : matrix){
            curr = transform(curr, arr);
            int currArea = largestRectangleArea(curr);
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;
    }

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
            int nse = n;
            int element = st.pop();
            int pse = st.isEmpty() ? -1 : st.peek();
            maxArea = Math.max(maxArea, heights[element] * (nse - pse - 1));
        }
        return maxArea;
    }

    public int[] transform(int[] curr, char[] arr){
        for(int i = 0; i < curr.length; i++){
            if(arr[i] == '0') curr[i] = 0;
            else curr[i] += arr[i] - '0';
        }
        return curr;
    }
}