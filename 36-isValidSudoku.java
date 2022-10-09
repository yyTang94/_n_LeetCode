import java.util.HashSet;
import java.util.Set;

class Solution {
    private boolean isDistinct(char[][] board, int rowStart, int rowLength, int colStart, int colLength) {
        /*
         * 2022-10-03 18:52:23
         * 2 ms (33.22%)
         * 41.3 MB (62.23%)
         */
        Set<Character> s = new HashSet<>();
        for (int i = rowStart; i < rowStart + rowLength; i++) {
            for (int j = colStart; j < colStart + colLength; j++) {
                if (board[i][j] != '.') {
                    if (s.contains(board[i][j])) {
                        return false;
                    } else {
                        s.add(board[i][j]);
                    }
                }
            }
        }
        return true;
    }

    public boolean fun1(char[][] board) {

        int nN = 9;
        int partK = 3;

        // rule: check row
        for (int i = 0; i < nN; i++) {
            if (!isDistinct(board, i, 1, 0, nN)) {
                return false;
            }
        }

        // rule: check col
        for (int i = 0; i < nN; i++) {
            if (!isDistinct(board, 0, nN, i, 1)) {
                return false;
            }
        }

        // rule: check box
        for (int i = 0; i < partK; i++) {
            for (int j = 0; j < partK; j++) {
                if (!isDistinct(board, i * 3, 3, j * 3, 3)) {
                    return false;
                }
            }
        }

        return true;

    }

    public boolean isValidSudoku(char[][] board) {
        return fun1(board);
    }
}