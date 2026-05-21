class Solution {
    public String longestPalindrome(String s) {
        int maxLen = 0;
        int start = -1;

        for(int i = 0; i < s.length(); i++){
            for(int j = i; j < s.length(); j++){
                if(isPallindrome(s, i, j)){
                    if(j - i + 1 > maxLen){
                        maxLen = j - i + 1;
                        start = i;
                    }
                }
            }
        }
        return s.substring(start, start + maxLen); // start , end
    }

    public boolean isPallindrome(String s, int i, int j){
        if(i >= j) return true;

        if(s.charAt(i) == s.charAt(j)){
            return isPallindrome(s, i + 1, j - 1);
        }
        return false;
    }
}