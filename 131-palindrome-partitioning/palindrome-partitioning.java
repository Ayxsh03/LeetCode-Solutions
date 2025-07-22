class Solution {
    public List<List<String>> partition(String s){
        List<List<String>> list = new ArrayList<>();
        List<String> ans = new ArrayList<>();
        backtrack(0, s, ans, list);
        return list;
    }

    void backtrack(int index, String s, List<String> ans, List<List<String>> list){
        int n = s.length();
        if(index == n){
            list.add(new ArrayList<>(ans));
            return;
        }

        for (int i = index + 1; i <= n; i++){
            String sub = s.substring(index, i);
            if (isPalindrome(sub)){
                ans.add(sub);
                backtrack(i, s, ans, list);
                ans.remove(ans.size() - 1);
            }
        }
    }

    boolean isPalindrome(String str) {
        int l = 0, r = str.length() - 1;
        while (l < r) {
            if (str.charAt(l) != str.charAt(r)) return false;
            l++; r--;
        }
        return true;
    }    
}