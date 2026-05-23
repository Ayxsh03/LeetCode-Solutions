class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        int n = strs.length;

        char[] s1 = strs[0].toCharArray();
        char[] s2 = strs[n - 1].toCharArray();

        StringBuilder sb = new StringBuilder();
        // S1 will be shorter naturally, as strs is sorted
        for(int i = 0; i < s1.length; i++){
            if(s1[i] != s2[i]) break; 
            sb.append(s1[i]);
        }
        return sb.toString();
    }
    
}