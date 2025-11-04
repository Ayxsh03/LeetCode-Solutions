class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] answer = new int[n-k+1];
        
        for (int i=0; i<=n-k;i++) {
            int[] subarray = Arrays.copyOfRange(nums,i,i+k);
            Map<Integer, Integer> frequencyMap = new HashMap<>();
            for (int num : subarray) {
                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
            List<Map.Entry<Integer, Integer>> sortedEntries = new ArrayList<>(frequencyMap.entrySet());
            sortedEntries.sort((a,b) -> {
                if (b.getValue().equals(a.getValue())) {
                    return b.getKey().compareTo(a.getKey());
                }
                return b.getValue().compareTo(a.getValue());
            });
            int xSum = 0;
            for (int j = 0; j < Math.min(x, sortedEntries.size()); j++) {
                Map.Entry<Integer, Integer> entry = sortedEntries.get(j);
                xSum += entry.getKey() * entry.getValue();
            }
            answer[i] = xSum;
        }
        return answer;
    }
}