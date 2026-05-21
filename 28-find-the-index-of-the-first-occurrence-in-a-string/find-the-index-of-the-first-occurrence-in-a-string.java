class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i < haystack.length(); i++){
            if(needle.charAt(0) == haystack.charAt(i)){
                if(check(haystack, needle, i)) return i;
            }
        }
        return -1;
    }

    public boolean check(String hay, String needle, int i){
        int n = needle.length();
        if(i + n > hay.length()) return false;

        for(int j = 0; j < needle.length(); j++){
            if(hay.charAt(i + j) != needle.charAt(j))
                return false;
        }

        return true;
    }
}