class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int n = grid.length;
        int size = n * n;
        int[] freq = new int[size + 1];
        int repeated=-1,missing=-1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int num = grid[i][j];
                freq[num]++;
            }
        }
        for (int num = 1; num <= size; num++) {
            if (freq[num] == 2) repeated = num;
            if (freq[num] == 0) missing = num;
        }
        return new int[]{ repeated, missing };
    }
}