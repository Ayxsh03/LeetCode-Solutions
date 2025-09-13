class Solution {
    public int maxFreqSum(String s) {
        s = s.toLowerCase();
        int arr[] = new int[26];
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            arr[ch - 'a']++;
        }
        int vowels = 0, cons = 0;
        for(int i = 0; i < 26; i++){
            if(( i == 0 || i == 4 || i == 8 || i == 14 || i == 20) && arr[i] > vowels) vowels = arr[i];
            else if(i != 0 && i != 4 && i != 8 && i != 14 && i != 20 && arr[i]>cons) cons = arr[i];
        }
        return vowels + cons;
    }
}