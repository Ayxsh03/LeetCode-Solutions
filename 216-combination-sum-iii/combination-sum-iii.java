class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list = new ArrayList<>();
        findCombination3(1, n, k, new ArrayList<>(), list);
        return list;
    }
    
    void findCombination3(int index, int target, int k, List<Integer> ans, List<List<Integer>> list){
        if(target == 0 && k == 0){
            list.add(new ArrayList<>(ans));
            return;
        }
        if(index > 9 || k < 0) return;
        for(int i = index; i <= 9; i++){
            if(i > target || k < 0) break;
            ans.add(i);
            findCombination3(i + 1, target - i, k - 1, ans, list);
            ans.remove(ans.size() - 1);
        }
    }
}