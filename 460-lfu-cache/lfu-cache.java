public class LFUCache {
    class Node {
        int key, val, count;
        Node prev, next;
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            count = 1;
        }
    }
    
    class DLList {
        Node dummyHead, dummyTail;
        int size;
        DLList() {
            dummyHead = new Node(-1, -1);
            dummyTail = new Node(-1, -1);
            dummyHead.next = dummyTail;
            dummyTail.prev = dummyHead;
        }
        
        void insertAfterHead(Node node) {
            dummyHead.next.prev = node;
            node.next = dummyHead.next;
            node.prev = dummyHead;
            dummyHead.next = node;
            size++;
        }
        
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
            size--;
        }
        
        Node removeLRU(){ //LRU
            if(size > 0){
                Node node = dummyTail.prev;
                remove(node);
                return node;
            }
            else return null;
        }
    }
    
    int capacity, size;
    int min; //always remembers the current lowest frequency among all nodes in the cache
    Map<Integer, Node> nodeMap;
    Map<Integer, DLList> countMap;

    LFUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap<>();
        countMap = new HashMap<>();
    }
    
    public int get(int key) {
        Node node = nodeMap.get(key);
        if (node == null) return -1;
        update(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        Node node;
        if (nodeMap.containsKey(key)) {
            node = nodeMap.get(key);
            node.val = value;
            update(node);
        }
        else {
            node = new Node(key, value);
            nodeMap.put(key, node);
            if (size == capacity) {
                DLList lastList = countMap.get(min);
                nodeMap.remove(lastList.removeLRU().key);
                size--;
            }
            size++;
            min = 1;
            // If there’s already a DLList for this frequency (node.count), return it
            // If not, create a fresh empty DLList.
            DLList newList = countMap.getOrDefault(node.count, new DLList());
            newList.insertAfterHead(node);
            countMap.put(node.count, newList);
        }
    }
    
    private void update(Node node) {
        DLList oldList = countMap.get(node.count);
        oldList.remove(node);
        if (node.count == min && oldList.size == 0) min++; 
        node.count++;
        DLList newList = countMap.getOrDefault(node.count, new DLList());
        newList.insertAfterHead(node);
        countMap.put(node.count, newList);
    }
}