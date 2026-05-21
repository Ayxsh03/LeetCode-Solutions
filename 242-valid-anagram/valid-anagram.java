class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false; 

        int freqA[] = new int[26];
        int freqB[] = new int[26];

        for(int i = 0; i < s.length(); i++){
            freqA[s.charAt(i) - 'a']++;
            freqB[t.charAt(i) - 'a']++;
        }

        for(int i = 0; i < freqA.length; i++){
            if(freqA[i] != freqB[i]) return false;
        }
        return true;
    }
}