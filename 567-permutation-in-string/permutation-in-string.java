class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] letterFrequencyS1 = new int[26];
        int[] letterFrequencyS2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            letterFrequencyS1[s1.charAt(i) - 'a']++;
            letterFrequencyS2[s2.charAt(i) - 'a']++;
        }

        if (Arrays.equals(letterFrequencyS1, letterFrequencyS2)) {
            return true;
        }

        for (int i = s1.length(); i < s2.length(); i++) {
            letterFrequencyS2[s2.charAt(i - s1.length()) - 'a']--;
            letterFrequencyS2[s2.charAt(i) - 'a']++;
            if (Arrays.equals(letterFrequencyS1, letterFrequencyS2)) {
                return true;
            }
        }

        return false;
    }
}