package medium.sortsearch._56_merge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(e -> e[0]));

        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = null;
        for (int i = 0; i < intervals.length; i++) {
            if (Objects.isNull(currentInterval)) {
                currentInterval = new int[2];
                currentInterval[0] = intervals[i][0];
                currentInterval[1] = intervals[i][1];
            } else {
                if (intervals[i][0] <= currentInterval[1]) {
                    currentInterval[1] = Math.max(intervals[i][1], currentInterval[1]);
                } else {
                    merged.add(currentInterval);

                    currentInterval = new int[2];
                    currentInterval[0] = intervals[i][0];
                    currentInterval[1] = intervals[i][1];
                }
            }
        }

        merged.add(currentInterval);

        return merged.toArray(new int[merged.size()][2]);
    }
}
