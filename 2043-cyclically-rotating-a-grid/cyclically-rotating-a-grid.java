class Solution {
    public int[][] rotateGrid(int[][] grid, int x) {
        int m = grid.length;
        int n = grid[0].length;

        int top = 0, bottom = m - 1;
        int left = 0, right = n - 1;

        while(top <= bottom && left <= right){
            int width = right - left + 1;
            int height = bottom - top + 1;
            int[] layer = new int[2 * (width + height) - 4];
            int k = 0;

            for(int j = left; j <= right; j++){
                layer[k] = grid[top][j];
                k++;
            }
            for(int i = top + 1; i <= bottom; i++){
                layer[k] = grid[i][right];
                k++;
            }
            for(int j = right - 1; j>= left; j--){
                layer[k] = grid[bottom][j];
                k++;
            }
            for(int i = bottom - 1; i > top; i--){
                layer[k] = grid[i][left];
                k++;
            }
            layer = rotate(layer, x);

            k = 0;
            for(int j = left; j <= right; j++){
                grid[top][j] = layer[k++];
            }
            for(int i = top + 1; i <= bottom; i++){
                grid[i][right] = layer[k++];
            }
            for(int j = right - 1; j>= left; j--){
                grid[bottom][j] = layer[k++];
            }
            for(int i = bottom - 1; i > top; i--){
                grid[i][left] = layer[k++];
            }

            top++;
            left++;
            right--;
            bottom--;
        }

        return grid;
    }

    public int[] rotate(int[] arr, int x) {
        int n = arr.length;
        x = x % n;

        reverse(arr, 0, x - 1);
        reverse(arr, x, n - 1);
        reverse(arr, 0, n - 1);

        return arr;
    }

    private void reverse(int[] arr, int l, int r) {
        while(l < r) {
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
    }
}