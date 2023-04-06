package _350_intersect;
import java.util.HashMap;
import java.util.Map;

class Solution { // 两个数组的交集 II
    public int[] intersect(int[] nums1, int[] nums2) {
        /*
         * 2022-10-03 16:14:10
         * time: 4 ms (20.71%)
         * memory: 42 MB (5.63%)
         */

        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            if (map1.containsKey(nums1[i])) {
                map1.put(nums1[i], map1.get(nums1[i]) + 1);
            } else {
                map1.put(nums1[i], 1);
            }
        }
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            if (map2.containsKey(nums2[i])) {
                map2.put(nums2[i], map2.get(nums2[i]) + 1);
            } else {
                map2.put(nums2[i], 1);
            }
        }

        int[] intersect = new int[nums1.length];
        int length = 0;
        for (Integer k : map1.keySet()) {
            int c1 = map1.getOrDefault(k, 0);
            int c2 = map2.getOrDefault(k, 0);

            for (int i = 0; i < Math.min(c1, c2); i++) {
                intersect[length] = k;
                length++;
            }

        }

        int[] rslt = new int[length];
        for (int i = 0; i < length; i++) {
            rslt[i] = intersect[i];
        }

        return rslt;
    }
}
