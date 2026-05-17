class Solution {
    public boolean canReach(int[] arr, int start) {
        return solve(arr, start);
    }

    public boolean solve(int[] arr, int i) {
        // Out of bounds or already visited
        if(i < 0 || i >= arr.length || arr[i] < 0)
            return false;

        // Reached zero
        if(arr[i] == 0)
            return true;

        int jump = arr[i];

        // Mark visited
        arr[i] = -arr[i];

        return solve(arr, i - jump) || solve(arr, i + jump);
    }
}