class Solution {
    static String[] key = {"","","abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv",  "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) return list;
        backtrack(0, new StringBuilder(), digits, list);
        return list;
    }
    
    void backtrack(int index, StringBuilder ans, String digits, List<String> list){
        if (ans.length() == digits.length()) {
            list.add(ans.toString());
            return;
        }
        char num = digits.charAt(index);
        String letters = key[num - '0'];
        for (char ch : letters.toCharArray()) {
            ans.append(ch);
            backtrack(index + 1, ans, digits, list);
            ans.deleteCharAt(ans.length() - 1); // backtrack
        }
    }
}