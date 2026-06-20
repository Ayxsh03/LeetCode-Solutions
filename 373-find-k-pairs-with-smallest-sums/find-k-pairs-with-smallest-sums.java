class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return ans;

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        Set<String> visited = new HashSet<>();

        minHeap.offer(new int[]{ nums1[0] + nums2[0], 0, 0} );
        visited.add("0#0");

        while (!minHeap.isEmpty() && k > 0) {
            int[] cur = minHeap.poll();
            int i = cur[1];
            int j = cur[2];
            ans.add(Arrays.asList(nums1[i], nums2[j]));

            if (i + 1 < nums1.length) {
                String key = (i + 1) + "#" + j;
                if (!visited.contains(key)) {
                    visited.add(key);
                    minHeap.offer(new int[]{ nums1[i + 1] + nums2[j], i + 1, j} );
                }
            }

            if (j + 1 < nums2.length) {
                String key = i + "#" + (j + 1);
                if (!visited.contains(key)) {
                    visited.add(key);
                    minHeap.offer(new int[]{ nums1[i] + nums2[j + 1], i, j + 1 } );
                }
            }
            k--;
        }

        return ans;
    }
}