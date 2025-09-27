class LRUCache {
    Node dummyHead = new Node(-1, -1), dummyTail = new Node(-1, -1);
    Map<Integer, Node> map = new HashMap();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        deleteNode(node);
        insertAfterHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            deleteNode(node);
            insertAfterHead(node);
        }else{
            if(map.size() == capacity) {
                Node LRU = dummyTail.prev;
                deleteNode(LRU);
                map.remove(LRU.key);
            }
            Node node = new Node(key, value);
            map.put(key, node);
            insertAfterHead(node);
        }
    }

    class Node{
        Node prev, next;
        int key, value;
        Node(int _key, int _value) {
            key = _key;
            value = _value;
        }
    }

    private void deleteNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        node.prev = null;
        node.next = null;
    }

    private void insertAfterHead(Node node) {
        Node next = dummyHead.next;
        node.next = next;
        node.prev = dummyHead;
        dummyHead.next = node;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */