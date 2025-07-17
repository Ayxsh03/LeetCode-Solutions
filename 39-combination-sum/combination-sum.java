class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        findCombSum(0, target, new ArrayList<>(), list, candidates);
        return list;
    }

    public static void findCombSum(int i, int target, List<Integer> ans, List<List<Integer>> list, int[] candidates){
        if(i == candidates.length){
            if(target == 0) list.add(new ArrayList<>(ans));
            return;
        }
        
        // Take the element if it doesn't exceed target
        if (candidates[i] <= target) {
            ans.add(candidates[i]);
            findCombSum(i, target - candidates[i], ans, list, candidates);
            ans.remove(ans.size() - 1); // backtrack
        }

        // Not take the element
        findCombSum(i + 1, target, ans, list, candidates);
        
    }
}