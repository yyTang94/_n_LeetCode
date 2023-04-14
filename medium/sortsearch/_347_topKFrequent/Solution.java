package medium.sortsearch._347_topKFrequent;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

class Solution {

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> n2c = new HashMap<>();
        for (int n : nums) {
            n2c.put(n, n2c.getOrDefault(n, 0) + 1);
        }

        int[] ans = n2c.entrySet().stream().sorted(new Comparator<Entry<Integer, Integer>>() {
            @Override
            public int compare(Entry<Integer, Integer> a, Entry<Integer, Integer> b) {
                if (a.getValue() > b.getValue()) {
                    return -1;
                } else if (a.getValue() < b.getValue()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        }).map(e -> e.getKey()).limit(k).mapToInt(Integer::intValue).toArray();

        return ans;
    }
}
