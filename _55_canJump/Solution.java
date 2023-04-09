package _55_canJump;

import java.util.Objects;

class Solution {
    public boolean canJump(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length == 0) {
            return false;
        }

        boolean[] canJumpArr = new boolean[nums.length];
        for (int i = 0; i < canJumpArr.length; i++) {
            canJumpArr[i] = false;
        }

        for (int i = canJumpArr.length - 1; i >= 0; i--) {
            if (i == canJumpArr.length - 1) {
                canJumpArr[i] = true;
            } else {
                for (int j = i + 1; j <= i + nums[i]; j++) {
                    if (canJumpArr[j]) {
                        canJumpArr[i] = true;
                        break;
                    }
                }
            }
        }

        return canJumpArr[0];
    }
}
