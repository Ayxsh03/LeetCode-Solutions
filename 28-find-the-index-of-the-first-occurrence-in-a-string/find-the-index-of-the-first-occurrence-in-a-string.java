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

        String s = hay.substring(i, i + n);
        if(s.equals(needle)) return true;

        return false;
    }
}