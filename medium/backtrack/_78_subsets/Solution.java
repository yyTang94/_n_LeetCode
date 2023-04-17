package medium.backtrack._78_subsets;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

class Solution {
    private void doSubsets(int[] nums, boolean[] useds, List<Integer> path, List<List<Integer>> subsetResult) {
        if (path.size() == nums.length) {
            subsetResult.add(new ArrayList<Integer>(path));
            return;
        }

        List<Integer> backUsedIndexes = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (!useds[i]) {
                useds[i] = true;
                path.add(nums[i]);

                doSubsets(nums, useds, path, subsetResult);

                backUsedIndexes.add(i);
                path.remove(path.size() - 1);
            }
        }

        for (Integer i : backUsedIndexes) {
            useds[i] = false;
        }

        subsetResult.add(new ArrayList<Integer>(path));
    }

    public List<List<Integer>> subsets(int[] nums) {
        // pre check
        if (Objects.isNull(nums)) {
            return null;
        }

        boolean[] useds = new boolean[nums.length];
        List<Integer> path = new ArrayList<>();

        List<List<Integer>> subsetResult = new ArrayList<>();

        doSubsets(nums, useds, path, subsetResult);

        return subsetResult;
    }
}
