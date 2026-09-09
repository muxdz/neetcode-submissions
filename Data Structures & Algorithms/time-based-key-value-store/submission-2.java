class TimeMap {
    HashMap<String, List<Node>> timeMap;

    class Node {
        String val;
        int time;

        public Node(String value, int timestamp) {
            val = value;
            time = timestamp;
        }
    }

    public TimeMap() {
        timeMap = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Node> current = timeMap.getOrDefault(key, new ArrayList<>());

        Node newNode = new Node(value, timestamp);

        current.add(newNode);
        timeMap.put(key, current);
    }
    
    public String get(String key, int timestamp) {
        List<Node> current = timeMap.get(key);

        if (current == null) return "";
        else {
            int left = 0;
            int right = current.size()-1;

            while (left <= right) {
                int middle = (left+right)/2;
                Node currentNode = current.get(middle);
                int time = currentNode.time;

                if (time == timestamp) return currentNode.val;
                if (time > timestamp) {
                    right = middle-1;
                }
                else {
                    left = middle+1;
                }
            }

            if (right < 0) return "";

            return current.get(right).val;
        }
    }
}
