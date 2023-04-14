package medium.sortsearch._75_sortColors;

import java.util.Objects;

class Solution {
    public void sortColors(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length <= 1) {
            return;
        }

        int leftBound = 0;
        int rightBound = nums.length - 1;

        int act = leftBound;
        while (act <= rightBound) {
            if (nums[act] == 0) {
                if (act == leftBound) {
                    act++;
                    leftBound++;
                } else {
                    // swap leftBound vs act
                    int temp = nums[leftBound];
                    nums[leftBound] = nums[act];
                    nums[act] = temp;

                    act++;
                    leftBound++;
                }
            } else if (nums[act] == 2) {
                if (act == rightBound) {
                    act++;
                    rightBound--;
                } else {
                    // swap rightBound vs act
                    int temp = nums[rightBound];
                    nums[rightBound] = nums[act];
                    nums[act] = temp;

                    rightBound--;
                }
            } else { // nums[act] == 1
                act++;
            }
        }

        return;
    }
}
