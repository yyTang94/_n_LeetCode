package medium.backtrack._46_permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    private void doPermute(int[] nums, boolean[] useds, List<Integer> track, List<List<Integer>> permuteResult) {
        if (track.size() == nums.length) {
            List<Integer> anResult = new ArrayList<>();
            anResult.addAll(track);
            permuteResult.add(anResult);
        }

        for (int i = 0; i < nums.length; i++) {
            if (!useds[i]) {
                track.add(nums[i]);
                useds[i] = true;

                doPermute(nums, useds, track, permuteResult);

                track.remove(track.size() - 1);
                useds[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        boolean[] useds = new boolean[nums.length];
        Arrays.fill(useds, false);

        List<Integer> track = new ArrayList<>();

        List<List<Integer>> permuteResult = new ArrayList<>();

        doPermute(nums, useds, track, permuteResult);

        return permuteResult;
    }
}
