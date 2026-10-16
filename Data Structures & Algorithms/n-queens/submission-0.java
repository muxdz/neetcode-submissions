class Solution {
    List<List<String>> results;
    List<String> board;
    HashSet<Integer> column;
    HashSet<Integer> posDiag;
    HashSet<Integer> negDiag;

    public List<List<String>> solveNQueens(int n) {
        results = new ArrayList<>();
        board = new ArrayList<>();
        column = new HashSet<>();
        posDiag = new HashSet<>();
        negDiag = new HashSet<>();

        String row = ".".repeat(n);
        for (int i=0; i<n; i++) {
            board.add(row);
        }

        solve(0, n);

        return results;
    }

    private void solve(int r, int n) {
        if (r == n) {
            results.add(new ArrayList<>(board));
            return;
        }

        for (int c=0; c<n; c++) {
            if (column.contains(c)
                || posDiag.contains(r+c)
                || negDiag.contains(r-c)
            ) continue;

            String row = board.get(r);
            char[] rowChars = row.toCharArray();
            rowChars[c] = 'Q';
            row = String.valueOf(rowChars);
            board.set(r, row);

            column.add(c);
            posDiag.add(r+c);
            negDiag.add(r-c);

            solve(r+1, n);

            board.set(r, ".".repeat(n));

            column.remove(c);
            posDiag.remove(r+c);
            negDiag.remove(r-c);
        }

    }
}
