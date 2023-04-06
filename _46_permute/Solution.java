package _46_permute;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length == 0) {
            return new ArrayList<>();
        }

        if (nums.length == 1) {
            return Arrays.asList(Arrays.asList(nums[0]));
        }

        List<List<Integer>> permute = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> subPermute = permute(Stream
                    .concat(Arrays.stream(Arrays.copyOfRange(nums, 0, i)).boxed(),
                            Arrays.stream(Arrays.copyOfRange(nums, i + 1, nums.length)).boxed())
                    .mapToInt(Integer::intValue)
                    .toArray());

            for (List<Integer> sub : subPermute) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[i]);
                temp.addAll(sub);

                permute.add(temp);
            }
        }
        return permute;
    }
}
