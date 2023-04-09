# 分析

快慢指针

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        // pre check
        if (nums.length <= 1) {
            return nums.length;
        }

        // first frame
        int slow = 0;
        int fast = 0;
        while (fast != nums.length - 1) {
            fast++;
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
```

查找重复片段

```java
class Solution {
    /*
     * 查找重复片段（fragment）
     */
    public int removeDuplicates(int[] nums) {
        // pre check
        if (Objects.isNull(nums) || nums.length == 0) {
            return 0;
        }

        int cachePosition = 0; // cache position

        int fragStart = 0; // start of a fragment
        int fragLength = 1; // the length of a fragment
        while (true) {
            int fragEnd = fragStart + fragLength - 1;

            // exit
            if (fragEnd >= nums.length) {
                nums[cachePosition] = nums[fragStart];
                break;
            }

            // iter
            if (nums[fragEnd] == nums[fragStart]) {
                fragLength++;
            } else {
                nums[cachePosition] = nums[fragStart];
                cachePosition++;

                fragStart = fragStart + fragLength - 1;
                fragLength = 1;

            }
        }

        return cachePosition + 1;
    }
}
```
