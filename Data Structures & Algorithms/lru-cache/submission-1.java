class LRUCache {
    Node head;
    Node tail;
    int size;
    int capacity;
    HashMap<Integer, Node> nodeMap;
    
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.value = val;
            this.prev = prev;
            this.next = next;
        }
    }

    public LRUCache(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.nodeMap = new HashMap<>(capacity);
    }
    
    public int get(int key) {
        Node recent = nodeMap.get(key);
        if (recent == null) return -1;

        moveToTail(recent);
        return recent.value;
    }
    
    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            Node recent = nodeMap.get(key);
            recent.value = value;
            moveToTail(recent);
            return;
        }

        if (size >= capacity) {
            nodeMap.remove(head.key);
            removeHead();

        }

        Node newNode = new Node(key, value, tail, null);
        addToTail(newNode);

        size++;
        nodeMap.put(key, newNode);    
    }

    private void moveToTail(Node node) {
        if (node == tail) return;

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }

        if (node.next != null) {
            node.next.prev = node.prev;
        }

        node.prev = tail;
        node.next = null;

        if (tail != null) {
            tail.next = node;
        }

        tail = node;
    }

    private void addToTail(Node node) {
        node.prev = tail;
        node.next = null;

        if (tail != null) {
            tail.next = node;
        } else {
            head = node;
        }

        tail = node;
    }

    private void removeHead() {
        if (head == null) {
            return;
        }

        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }
}
