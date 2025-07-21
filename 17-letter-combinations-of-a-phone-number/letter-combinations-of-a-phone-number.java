class Solution {
    public List<String> letterCombinations(String digits) {
        Map<Character, String> map = Map.of(
            '2', "abc", '3', "def", '4', "ghi", '5', "jkl",
            '6', "mno", '7', "pqrs", '8', "tuv", '9', "wxyz"
        );
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        backtrack(0, new StringBuilder(), digits, list, map);
        return list;
    }
    
    void backtrack(int index, StringBuilder ans, String digits, List<String> list,  Map<Character, String> map){
        if (ans.length() == digits.length()) {
            list.add(ans.toString());
            return;
        }
        String letters = map.get(digits.charAt(index));
        for (char ch : letters.toCharArray()) {
            ans.append(ch);
            backtrack(index + 1, ans, digits, list, map);
            ans.deleteCharAt(ans.length() - 1); // backtrack
        }
    }
}