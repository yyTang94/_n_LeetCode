package medium.treegraph._200_numIslands;

class Solution {
    private void tag(char[][] grid, int i, int j) {
        grid[i][j] = '*';
        if (i - 1 >= 0 && grid[i - 1][j] == '1') {
            tag(grid, i - 1, j);
        }

        if (i + 1 <= grid.length - 1 && grid[i + 1][j] == '1') {
            tag(grid, i + 1, j);
        }

        if (j - 1 >= 0 && grid[i][j - 1] == '1') {
            tag(grid, i, j - 1);
        }

        if (j + 1 <= grid[0].length - 1 && grid[i][j + 1] == '1') {
            tag(grid, i, j + 1);
        }
    }

    public int numIslands(char[][] grid) {
        int cnt = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    cnt++;
                    tag(grid, i, j);
                }
            }
        }
        return cnt;
    }
}
