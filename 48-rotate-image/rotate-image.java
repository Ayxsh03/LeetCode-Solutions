class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //Transpose
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        //Reverse Row
        for (int i = 0; i < n; i++)
            reverseArr(matrix[i]);

        return;
    }

    public int[] reverseArr(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }
}