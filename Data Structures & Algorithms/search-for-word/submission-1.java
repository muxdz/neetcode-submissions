class Solution {
    boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];

        for (int row=0; row<board.length; row++) {
            for (int col=0; col<board[0].length; col++) {
                if (visit(board, word, 0, row, col)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean visit(char[][] board, String word, int i, int row, int col) {
        if (i == word.length()) {
            return true;
        }
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length) {
            return false;
        }

        if (visited[row][col] || board[row][col] != word.charAt(i)) {
            return false;
        }

        int[] coord = {row, col};

        visited[row][col] = true;
        
        boolean found = visit(board, word, i+1, row-1, col)
             || visit(board, word, i+1, row+1, col)
             || visit(board, word, i+1, row, col-1)
             || visit(board, word, i+1, row, col+1);

        visited[row][col] = false;

        return found;
    }
}
