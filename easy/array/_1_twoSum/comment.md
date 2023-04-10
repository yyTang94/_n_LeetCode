
查字典

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] abIdx = new int[2];

        Map<Integer, Integer> num2Idx = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int b = nums[i];
            int a = target - b;

            if (num2Idx.containsKey(a)) {
                abIdx[0] = num2Idx.get(a);
                abIdx[1] = i;
                break;
            } else {
                num2Idx.put(b, i);
            }

        }

        return abIdx;
    }
}
```

先排序

```java
```
