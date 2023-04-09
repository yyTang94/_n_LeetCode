package _62_uniquePaths;

class Solution {
    public int uniquePaths(int m, int n) {
        // pre check
        if (m == 0 || n == 0) {
            return 0;
        }

        int[][] pathArr = new int[m][n];
        for (int k = 1; k <= Math.min(m, n); k++) {
            int i = m - k;
            int j = n - k;
            if (i == m - 1 && j == n - 1) {
                pathArr[i][j] = 1;
            } else {
                pathArr[i][j] = pathArr[i + 1][j] + pathArr[i][j + 1];
            }
            // i dir
            for (int backI = i - 1; backI >= 0; backI--) {
                pathArr[backI][j] = 0;
                if (backI + 1 <= m - 1) {
                    pathArr[backI][j] += pathArr[backI + 1][j];
                }
                if (j + 1 <= n - 1) {
                    pathArr[backI][j] += pathArr[backI][j + 1];
                }
            }

            // j dir
            for (int backJ = j - 1; backJ >= 0; backJ--) {
                pathArr[i][backJ] = 0;
                if (i + 1 <= m - 1) {
                    pathArr[i][backJ] += pathArr[i + 1][backJ];
                }
                if (backJ + 1 <= n - 1) {
                    pathArr[i][backJ] += pathArr[i][backJ + 1];
                }
            }
        }

        return pathArr[0][0];
    }

    public static void main(String[] args) {
        new Solution().uniquePaths(3, 7);
    }
}
