class Solution {
    public int maxFreqSum(String s){
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) mp.put(ch, mp.getOrDefault(ch, 0) + 1);

        int vowel = 0;
        int consonant = 0;
        for(char c = 'a'; c <= 'z'; c++){
            if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'){
                vowel = Math.max(vowel, mp.getOrDefault(c, 0));
            }
            else consonant = Math.max(consonant, mp.getOrDefault(c, 0));
        }
        return vowel + consonant;
    }
}