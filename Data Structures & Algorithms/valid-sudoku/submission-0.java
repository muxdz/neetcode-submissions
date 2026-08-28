class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rowSet = new ArrayList<>();
        List<Set<Character>> columnSet = new ArrayList<>();
        List<Set<Character>> squareSet = new ArrayList<>();

        for (int i=0; i<board.length; i++) {
            Set<Character> rSet = new HashSet<>();
            Set<Character> cSet = new HashSet<>();
            Set<Character> sSet = new HashSet<>();

            rowSet.add(i, rSet);
            columnSet.add(i, cSet);
            squareSet.add(i, sSet);
        }

        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board.length; j++) {
                char cell = board[i][j];
                if (cell == '.') continue;

                int squareIndex = (int) ((i/3)*3 + j/3);

                Set<Character> rSet = rowSet.get(i);
                Set<Character> cSet = columnSet.get(j);
                Set<Character> sSet = squareSet.get(squareIndex);

                if (rSet.contains(cell) || cSet.contains(cell) || sSet.contains(cell)) return false;

                rSet.add(cell);
                cSet.add(cell);
                sSet.add(cell);
            }
        }

        return true;
    }
}
