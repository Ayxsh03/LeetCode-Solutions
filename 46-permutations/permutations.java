class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        permutations(0, new ArrayList<>(), list, nums);
        return list;
    }

    void permutations(int index, List<Integer> ans, List<List<Integer>> list, int[] nums) {
        if (ans.size() == nums.length) {
            list.add(new ArrayList<>(ans)); // Make a copy before adding
            return;
        }

        for (int num : nums) {
            if (!ans.contains(num)) {
                ans.add(num);
                permutations(index + 1, ans, list, nums);
                ans.remove(ans.size() - 1); // Backtrack
            }
        }
    }
}