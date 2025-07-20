class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        findSubset(0, new ArrayList<>(), list, nums);
        return list;
    }

    public void findSubset(int index, List<Integer> ans, List<List<Integer>> list,int[] nums){
        int n = nums.length;
        if(index == n){
            list.add(new ArrayList<>(ans));
            return;
        }
        ans.add(nums[index]);
        findSubset(index + 1, ans, list, nums);
        ans.remove(ans.size()-1);
        findSubset(index + 1, ans, list, nums);
    }
}
