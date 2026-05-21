class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; 

        //Single Array instead of 2
        int freq[] = new int[26];

        // Increase for s, decrease for t.
        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for(int i = 0; i < 26; i++){
            if(freq[i] != 0) return false;
        }
        return true;
    }
}