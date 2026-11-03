class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        PrefixTree tree = new PrefixTree();

        for (String word : words) {
            tree.insert(word);
        }

        List<String> result = new ArrayList<>();

        for (int row=0; row < board.length; row++) {
            for (int col=0; col < board[0].length; col++) {
                dfs(board, row, col, tree.root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int row, int col, PrefixTree.Node node, List<String> result) {
        if (0 > row || row >= board.length) {
            return;
        }

        if (0 > col || col >= board[0].length) {
            return;
        }

        if (board[row][col] == '#') {
            return;
        }

        char curr = board[row][col];

        if (node.children[curr - 'a'] == null) {
            return;
        }

        node = node.children[curr - 'a'];

        if (node.endOfWord) {
            result.add(node.word);
            node.endOfWord = false;
        }

        board[row][col] = '#';

        dfs(board, row + 1, col, node, result);
        dfs(board, row - 1, col, node, result);
        dfs(board, row, col + 1, node, result);
        dfs(board, row, col - 1, node, result);

        board[row][col] = curr;
    }

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
            curr.word = word;
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
            String word;

            public Node() {
                endOfWord = false;
                children = new Node[26];
                word = null;
            }
        }
    }
}
