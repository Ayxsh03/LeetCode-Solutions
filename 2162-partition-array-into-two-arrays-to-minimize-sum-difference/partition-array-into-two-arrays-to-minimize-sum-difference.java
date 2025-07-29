class Solution {
    public int minimumDifference(int[] nums) {
        int N = nums.length;
        int n = N / 2;

        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int[] leftArr = Arrays.copyOfRange(nums, 0, n);
        int[] rightArr = Arrays.copyOfRange(nums, n, N);

        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();

        generateSubsetSums(0, 0, 0, leftArr, leftMap);
        generateSubsetSums(0, 0, 0, rightArr, rightMap);

        for (List<Integer> list : rightMap.values()) {
            Collections.sort(list);
        }

        int minDiff = Integer.MAX_VALUE;

        for (int k = 0; k <= n; k++) {
            List<Integer> leftSums = leftMap.getOrDefault(k, new ArrayList<>());
            List<Integer> rightSums = rightMap.getOrDefault(n - k, new ArrayList<>());

            for (int s1 : leftSums) {
                int target = totalSum / 2 - s1;
                int idx = lowerBound(rightSums, target);

                // Check idx
                if (idx < rightSums.size()) {
                    int s2 = rightSums.get(idx);
                    int total = s1 + s2;
                    int other = totalSum - total;
                    minDiff = Math.min(minDiff, Math.abs(total - other));
                }

                // Check idx - 1
                if (idx > 0) {
                    int s2 = rightSums.get(idx - 1);
                    int total = s1 + s2;
                    int other = totalSum - total;
                    minDiff = Math.min(minDiff, Math.abs(total - other));
                }
            }
        }

        return minDiff;
    }

    private void generateSubsetSums(int i, int sum, int count, int[] arr, Map<Integer, List<Integer>> map) {
        if (i == arr.length) {
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
            return;
        }
        generateSubsetSums(i + 1, sum + arr[i], count + 1, arr, map);
        generateSubsetSums(i + 1, sum, count, arr, map);
    }

    private int lowerBound(List<Integer> arr, int target) {
        int low = 0, high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) < target) low = mid + 1;
            else high = mid;
        }
        return low;
    }
}
