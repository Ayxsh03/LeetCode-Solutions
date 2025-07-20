class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);  // Sort to bring duplicates together
        List<List<Integer>> list = new ArrayList<>();
        findSubset2(0, new ArrayList<>(), list, nums);
        return list;
    }

    public void findSubset2(int index, List<Integer> ans, List<List<Integer>> list, int[] nums) {
        list.add(new ArrayList<>(ans));

        for (int i = index; i < nums.length; i++) {
            // Skip duplicates
            if (i > index && nums[i] == nums[i - 1]) continue;

            ans.add(nums[i]);
            findSubset2(i + 1, ans, list, nums);
            ans.remove(ans.size() - 1);  // backtrack
        }
    }
}