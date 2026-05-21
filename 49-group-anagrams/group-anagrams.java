class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String word : strs){
            char[] ch = word.toCharArray();
            Arrays.sort(ch);

            String key = String.valueOf(ch);

            if( !map.containsKey(key) ){
                List<String> list = new ArrayList<>();
                list.add(word);
                map.put(key, list);
            }
            
            else map.get(key).add(word);
            
        }
        return new ArrayList<>(map.values());
    }
}