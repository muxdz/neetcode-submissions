class WordDictionary {
    Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
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

        return dfs(curr, word, 0);
    }

    private boolean dfs(Node curr, String word, int index) {
        if (index == word.length()) {
            return curr.endOfWord;
        }

        char c = word.charAt(index);

        if (c == '.') {
            for (Node child : curr.children) {
                if (child != null && dfs(child, word, index+1)) {
                    return true;
                }
            }

            return false;
        }

         if (curr.children[c - 'a'] == null) return false;

        curr = curr.children[c - 'a'];

        return dfs(curr, word, index + 1);
    }

    class Node {
        Node[] children;
        boolean endOfWord;

        public Node() {
            children = new Node[26];
            endOfWord = false;
        }
    }
}
