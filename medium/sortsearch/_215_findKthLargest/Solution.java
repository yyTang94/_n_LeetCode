package medium.sortsearch._215_findKthLargest;

import java.util.Objects;
import java.util.Random;

class Solution {
    /*
     * method: by bubble
     */
    public int bubble(int[] nums, int k) {
        // pre check
        if (Objects.isNull(nums) || nums.length < k) {
            return -1;
        }

        // bubble
        for (int iThFromEnd = 1; iThFromEnd <= k; iThFromEnd++) {
            for (int j = 0; j < nums.length - iThFromEnd; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums[nums.length - k];
    }

    /*
     * method: by quick sort
     */

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private int doQuick(int[] nums, int start, int length, int k) {
        Random random = new Random();
        int chosenPos = random.nextInt(length) + start;
        int chosenNum = nums[chosenPos];

        int left = start;
        int right = start + length - 1;
        while (true) {
            while (left <= right) {
                if (nums[left] <= chosenNum) {
                    left++;
                } else {
                    break;
                }
            }

            while (right >= left) {
                if (nums[right] >= chosenNum) {
                    right--;
                } else {
                    break;
                }
            }

            if (left > right) {
                int fromPos = chosenPos;
                int toPos;
                if (chosenPos <= right) {
                    toPos = right;
                } else {
                    toPos = left;
                }

                swap(nums, fromPos, toPos);

                if (toPos == nums.length - k) {
                    return nums[toPos];
                } else {
                    if (toPos < nums.length - k) {
                        return doQuick(nums, toPos, length - (toPos - start), k);
                    } else {
                        return doQuick(nums, start, toPos - start, k);
                    }
                }
            } else {
                swap(nums, left, right);
            }
        }
    }

    public int quick(int[] nums, int k) {
        // pre check
        if (Objects.isNull(nums) || nums.length < k) {
            return -1;
        }
        return doQuick(nums, 0, nums.length, k);
    }

    public int findKthLargest(int[] nums, int k) {
        return quick(nums, k);
    }
}
