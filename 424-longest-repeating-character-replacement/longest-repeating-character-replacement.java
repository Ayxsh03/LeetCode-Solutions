class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26]; // For characters A-Z
        int maxLen = 0, l = 0, r = 0;
        int maxFreq = 0;

        while (r < s.length()) {
            char c = s.charAt(r);
            freq[c -'A']++;  // Map char to 0-25
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            
            int totalChars = r - l + 1;
            if (totalChars - maxFreq > k) {
                freq[s.charAt(l) - 'A']--; // Shrink window
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}