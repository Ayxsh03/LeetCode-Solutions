class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1;
        int high = 0;
        for(int num: nums) high = Math.max(high, num);
        int ans = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else
                low = mid + 1;
        }
        return ans;
    }

    private boolean isValid(int[] nums, int div, int threshold) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + div - 1) / div; // same as ceil(num / div)
        }
        return sum <= threshold;
    }
}