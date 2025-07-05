class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, l = 0, r = 0;
        int maxFreq = 0;
        Map<Character, Integer> map = new HashMap<>();

        while (r < s.length()) {
            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            maxFreq = Math.max(maxFreq, map.get(c));
            int totalChars = r - l + 1;

            if (totalChars - maxFreq > k) {
                char leftChar = s.charAt(l);
                map.put(leftChar, map.get(leftChar) - 1);
                if (map.get(leftChar) == 0) map.remove(leftChar);
                l++;
            }

            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }

        return maxLen;
    }
}