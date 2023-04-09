
$$
i^{t+1} = (i^t + n * k) \% L
$$

- 经过若干圈之后，一定会回到起点
- 如果还有没有遍历到的元素，那起点一定是上一个起点
- 通过记录遍历的个数来判断结束与否

buffer办法

```java
class Solution {
    public void rotate(int[] nums, int k) {
        k = k % nums.length;

        int[] bufK = new int[k];
        for (int i = nums.length - k; i < nums.length; i++) {
            bufK[i - (nums.length - k)] = nums[i];
        }

        for (int i = nums.length - k - 1; i >= 0; i--) {
            nums[i + k] = nums[i];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = bufK[i];
        }
    }
}
```

非buffer办法

```java
class Solution {
    public void rotate(int[] nums, int k) {
        int aggCount = 0;

        for (int i = 0; i < nums.length; i++) {
            if (aggCount >= nums.length) {
                break;
            }

            int source = i;
            int target = (source + k) % nums.length;

            int cache = nums[source];

            do {
                int temp;
                temp = nums[target];
                nums[target] = cache;
                cache = temp;

                source = target;
                target = (source + k) % nums.length;

                aggCount++;
            } while (source != i);
        }
    }
}
```
