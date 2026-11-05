class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxCount = 0;

        for (int i=0; i<grid.length; i++) {
            for (int j=0; j<grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int val = dfs(grid, i, j);
                    maxCount = Math.max(val, maxCount);
                }
            }
        }

        return maxCount;
    }

    private int dfs(int[][] grid, int row, int col) {
        if (grid[row][col] == 0) {
            return 0;
        }

        grid[row][col] = 0;

        int val1 = 0;
        int val2 = 0;
        int val3 = 0;
        int val4 = 0;

        if (row > 0) {
            val1 = dfs(grid, row-1, col);
        }
        if (row < grid.length - 1) {
            val2 = dfs(grid, row+1, col);
        }
        if (col > 0) {
            val3 = dfs(grid, row, col-1);
        }
        if (col < grid[0].length - 1) {
            val4 = dfs(grid, row, col+1);
        }

        return 1 + val1 + val2 + val3 + val4;
    }
}
