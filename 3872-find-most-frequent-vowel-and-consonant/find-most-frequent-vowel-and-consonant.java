class Solution {
    public int maxFreqSum(String s) {
        HashMap<Character, Integer> map1 = new HashMap<>(); // vowel frequency
        HashMap<Character, Integer> map2 = new HashMap<>(); // consonant frequency
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') map1.put(ch, map1.getOrDefault(ch, 0) + 1);
            else map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }
        
        int maxVowel = 0, maxCons = 0;
        for (int freq : map1.values()) maxVowel = Math.max(maxVowel, freq);
        for (int freq : map2.values()) maxCons = Math.max(maxCons, freq);
        
        return maxVowel + maxCons;
    }
}