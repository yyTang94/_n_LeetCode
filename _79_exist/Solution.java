package _79_exist;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Solution {
    private boolean doExist(char[][] board, Set<String> used, int row, int col, String word) {
        char targetChar = word.charAt(0);
        if (board[row][col] == targetChar) {
            if (word.length() == 1) {
                return true;
            } else {
                int[][] neighbors = new int[][] { { row, col - 1 }, { row, col + 1 }, { row - 1, col },
                        { row + 1, col } };

                for (int[] nei : neighbors) {
                    int nextRow = nei[0];
                    int nextCol = nei[1];
                    if ((0 <= nextRow && nextRow <= board.length - 1)
                            && (0 <= nextCol && nextCol <= board[0].length - 1)
                            && !used.contains(String.valueOf(nextRow) + "-" + String.valueOf(nextCol))) {

                        char tempChar = board[row][col];
                        board[row][col] = '.';
                        boolean flag = doExist(board, used, nextRow, nextCol,
                                word.substring(1, word.length()));
                        if (flag) {
                            return true;
                        }

                        board[row][col] = tempChar;
                    }
                }
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean exist(char[][] board, String word) {
        // pre check
        if (Objects.isNull(board) || board.length == 0 || board[0].length == 0 || Objects.isNull(word)
                || word.length() == 0) {
            return false;
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                boolean flag = doExist(board, new HashSet<>(), i, j, word);
                if (flag) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {

        char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
        new Solution().exist(board, "ABCCED");

        System.out.println("Hello, World!");

    }
}
