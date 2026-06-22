class Solution {
    public int maxNumberOfBalloons(String text) {
        int[] map = new int[26];
        for(char ch : text.toCharArray()) map[ch - 'a']++;
        int b = map[1];
        int a = map[0];
        int l = map[11];
        int o = map[14];
        int n = map[13];

        return Math.min(
            Math.min(b, a),
            Math.min(Math.min(l/2, o/2), n));
    }
}