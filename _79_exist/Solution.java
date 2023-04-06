package _79_exist;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Solution {
    private boolean doExist(char[][] board, Set<String> used, int row, int col, String word) {
        char targetChar = word.charAt(0);
        if (board[row][col] == targetChar) {
            if (word.length() == 1) {
                return true;
            } else {
                List<Map<String, Integer>> preNeighbors = new ArrayList<>();
                preNeighbors.add(Stream.of(
                        new AbstractMap.SimpleEntry<>("row", row),
                        new AbstractMap.SimpleEntry<>("col", col - 1))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                preNeighbors.add(Stream.of(
                        new AbstractMap.SimpleEntry<>("row", row),
                        new AbstractMap.SimpleEntry<>("col", col + 1))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                preNeighbors.add(Stream.of(
                        new AbstractMap.SimpleEntry<>("row", row - 1),
                        new AbstractMap.SimpleEntry<>("col", col))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
                preNeighbors.add(Stream.of(
                        new AbstractMap.SimpleEntry<>("row", row + 1),
                        new AbstractMap.SimpleEntry<>("col", col))
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

                List<Map<String, Integer>> neighbors = new ArrayList<>();
                for (Map<String, Integer> m : preNeighbors) {
                    if ((0 <= m.get("row") && m.get("row") <= board.length - 1)
                            && (0 <= m.get("col") && m.get("col") <= board[0].length - 1)
                            && !used.contains(String.valueOf(m.get("row")) + "-" + String.valueOf(m.get("col")))) {
                        neighbors.add(m);
                    }
                }

                for (Map<String, Integer> m : neighbors) {
                    Set<String> nextUsed = new HashSet<>();
                    nextUsed.addAll(used);
                    nextUsed.add(String.valueOf(row) + "-" + String.valueOf(col));
                    boolean flag = doExist(board, nextUsed, m.get("row"), m.get("col"),
                            word.substring(1, word.length()));
                    if (flag) {
                        return true;
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
}
