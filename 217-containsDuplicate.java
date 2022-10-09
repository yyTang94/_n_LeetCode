import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean fun1(int[] nums) {
        /*
         * 2022-10-03 15:37:49
         * time: 7 ms (74.58%)
         * memory: 53.3 MB (60.52%)
         */

        Set<Integer> s = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (s.contains(nums[i])) {
                return true;
            } else {
                s.add(nums[i]);
            }

        }

        return false;

    }

    public boolean containsDuplicate(int[] nums) {
        return fun1(nums);
    }
}