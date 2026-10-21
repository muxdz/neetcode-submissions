class PrefixTree {
    Node root;

    public PrefixTree() {
        root = new Node();
    }

    public void insert(String word) {
        Node curr = root;

        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                Node newNode = new Node();
                curr.children[c - 'a'] = newNode;
            }

            curr = curr.children[c - 'a'];
        }

        curr.endOfWord = true;
    }

    public boolean search(String word) {
        Node curr = root;

        for (char c: word.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }

        return curr.endOfWord;
    }

    public boolean startsWith(String prefix) {
        Node curr = root;

        for (char c: prefix.toCharArray()) {
            if (curr.children[c - 'a'] == null) return false;
            curr = curr.children[c - 'a'];
        }

        return true;
    }

    class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            endOfWord = false;
            children = new Node[26];
        }
    }
}
