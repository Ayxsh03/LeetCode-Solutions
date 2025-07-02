class Solution {
    public int totalFruit(int[] fruits) {
        if (fruits.length == 1)
            return 1;

        int l = 0, r = 0, max_len = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        while (r < fruits.length) {
            map.put(fruits[r], r); // update last index of current fruit

            if (map.size() > 2) {
                int minIndex = Collections.min(map.values());
                int elem = fruits[minIndex];
                map.remove(elem);
                l = minIndex + 1;
            }

            max_len = Math.max(max_len, r - l + 1);
            r++;
        }
        return max_len;
    }
}