class Solution {
    // Up, Right, Down, Left
    public int[] dx = {-1, 0, 1, 0};
    public int[] dy = {0, 1, 0, -1};

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int[][] ans = image;
        int oldColor = image[sr][sc];
        if(oldColor == color) return image;
        
        ans[sr][sc] = color;
        dfs(sr, sc, image, ans, oldColor, color);
        return ans;
  }

    public void dfs(int r, int c,int[][] image, int[][] ans, int oldColor, int color){
        for(int i = 0; i < 4; i++){
            int row = dx[i] + r;
            int col = dy[i] + c;
            if(row >= ans.length || row < 0 || col >= image[0].length || col < 0) continue;
            if(image[row][col] == oldColor){
                ans[row][col] = color;
                dfs(row, col, image, ans, oldColor, color);
            }
        }
    }
}