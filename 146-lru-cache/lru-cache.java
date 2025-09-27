class LRUCache {

    ArrayList<Pair> cache;
    int n;

    public LRUCache(int capacity) {
        cache = new ArrayList<>();
        n = capacity;
    }
    
    public int get(int key) {
        for (int i = 0; i < cache.size(); i++) {
            Pair p = cache.get(i);
            if (p.key == key) {
                // Move accessed pair to the end (most recently used)
                cache.remove(i);
                cache.add(p);
                return p.value;
            }
        }
        return -1; // Not found
    }
    
    public void put(int key, int value) {
        // If key already exists, update it and move to end
        for (int i = 0; i < cache.size(); i++) {
            if (cache.get(i).key == key) {
                cache.remove(i);
                cache.add(new Pair(key, value));
                return;
            }
        }
        
        // If capacity not full, just add
        if (cache.size() < n) {
            cache.add(new Pair(key, value));
        } 
        // Otherwise remove least recently used (front) and add new
        else {
            cache.remove(0);
            cache.add(new Pair(key, value));
        }
    }

    private static class Pair {
        int key, value;
        Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */