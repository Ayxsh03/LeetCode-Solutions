class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] pse = getPSE(heights, n);
        int[] nse = getNSE(heights, n); 
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int left = i - pse[i];
            int right = nse[i] - i;
            int width = left + right - 1;
            int area = heights[i] * width;
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int[] getPSE(int[] arr, int n) {
        int[] pse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            pse[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return pse;
    }

    private int[] getNSE(int[] arr, int n) {
        int[] nse = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            nse[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return nse;
    }
}