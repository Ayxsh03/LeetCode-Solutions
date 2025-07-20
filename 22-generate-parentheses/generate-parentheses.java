class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generate(n, n, new StringBuilder(), list);
        return list;
    }

    public static void generate(int open, int close, StringBuilder ans, List<String> list){
        if (open == 0 && close == 0) {
            list.add(ans.toString());
            return;
        }

        if (open > 0){
            ans.append('(');
            generate(open - 1, close, ans, list);
            ans.deleteCharAt(ans.length() - 1); // backtrack
        }

        if (close > open && close > 0){ // only add ')' if more ')' are remaining than '('
            ans.append(')');
            generate(open, close - 1, ans, list);
            ans.deleteCharAt(ans.length() - 1); // backtrack
        }
    }
}