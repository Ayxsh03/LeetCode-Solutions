class Solution {
    int[][] memo;

    public String longestPalindrome(String s) {
        int n = s.length();
        memo = new int[n][n];

        for(int[] row : memo) Arrays.fill(row, -1);

        int maxLen = 0;
        int start = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                if(isPalindrome(s, i, j)){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen);
    }

    public boolean isPalindrome(String s, int i, int j){
        if(i >= j) return true;

        if(memo[i][j] != -1) return memo[i][j] == 1;

        if(s.charAt(i) == s.charAt(j)){
            memo[i][j] = isPalindrome(s, i + 1, j - 1) ? 1 : 0;
        }
        else memo[i][j] = 0;

        return memo[i][j] == 1;
    }
}