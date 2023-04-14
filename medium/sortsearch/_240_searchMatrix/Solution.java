package medium.sortsearch._240_searchMatrix;

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int col = matrix[0].length - 1;
        while ((0 <= row && row <= matrix.length - 1) && (0 <= col && col <= matrix[0].length - 1)) {
            if (matrix[row][col] == target) {
                return true;
            }

            if (target > matrix[row][col]) {
                row++;
            } else {
                col--;
            }
        }

        return false;
    }
}
