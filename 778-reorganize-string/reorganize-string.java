class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
            if (freq[ch - 'a'] > (n + 1) / 2) return "";
        }

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> b.freq - a.freq);

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) { 
                maxHeap.offer(new Pair((char) ('a' + i), freq[i]));
            }
        }

        StringBuilder sb = new StringBuilder();
        Pair prev = null;

        while (!maxHeap.isEmpty()) {
            Pair p = maxHeap.poll();
            sb.append(p.ch);
            p.freq--;

            if (prev != null && prev.freq > 0) {
                maxHeap.offer(prev);
            }
            prev = p;
        }

        return sb.toString();
    }
    
    public class Pair {
        char ch;
        int freq;

        Pair(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }
    }
}