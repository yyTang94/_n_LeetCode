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
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                // 从[i,j]这个坐标开始查找
                if (dfs(board, words, i, j, 0))
                    return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int index) {
        List<Map<String, Integer>> preNeighbors = new ArrayList<>();
        int row = 2;
        int col = 2;
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

        // 边界的判断，如果越界直接返回false。index表示的是查找到字符串word的第几个字符，
        // 如果这个字符不等于board[i][j]，说明验证这个坐标路径是走不通的，直接返回false
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[index])
            return false;
        // 如果word的每个字符都查找完了，直接返回true
        if (index == word.length - 1)
            return true;
        // 把当前坐标的值保存下来，为了在最后复原
        char tmp = board[i][j];
        // 然后修改当前坐标的值
        board[i][j] = '.';
        // 走递归，沿着当前坐标的上下左右4个方向查找
        boolean res = dfs(board, word, i + 1, j, index + 1)
                || dfs(board, word, i - 1, j, index + 1)
                || dfs(board, word, i, j + 1, index + 1)
                || dfs(board, word, i, j - 1, index + 1);
        // 递归之后再把当前的坐标复原
        board[i][j] = tmp;
        return res;
    }

}