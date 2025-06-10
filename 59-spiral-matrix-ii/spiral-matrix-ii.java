class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int top = 0, left = 0;
        int bottom = n - 1, right = n - 1;
        int x = 1;
        while (left <= right && top <= bottom) {
            if (x > n*n) break;
            //right
            for (int i = left; i <= right; i++)
                ans[top][i] = x++;
            top++;

            //down
            for (int i = top; i <= bottom; i++)
                ans[i][right] = x++;
            right--;

            //left
            for (int i = right; i >= left; i--)
                ans[bottom][i] = x++;
            bottom--;

            //up
            for (int i = bottom; i >= top; i--)
                ans[i][left] = x++;
            left++;

        }
        return ans;
    }
}