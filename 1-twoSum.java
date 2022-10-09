import java.util.*;

class Solution {
    private int[] fun20221001(int[] nums, int target) {
        /*
         * time: 6ms (45.83%)
         * memory: 42.2MB (8.07%)
         */
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer tempN = Integer.valueOf(nums[i]);
            if (numMap.containsKey(tempN)) {
                numMap.put(tempN, numMap.get(tempN) + 1);
            } else {
                numMap.put(tempN, 1);
            }
        }

        Integer myN = null;
        Integer brotherN = null;
        for (int i = 0; i < nums.length; i++) {
            myN = nums[i];
            brotherN = target - myN;
            if (brotherN != myN) {
                if (numMap.containsKey(brotherN)) {
                    break;
                }
            } else {
                if (numMap.getOrDefault(brotherN, 0) >= 2) {
                    break;
                }
            }
        }

        Integer myI = null;
        Integer brotherI = null;
        if (brotherN != null) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[j] == brotherN && brotherI == null) {
                    brotherI = j;
                } else if (nums[j] == myN) {
                    myI = j;
                }
            }
        }

        int[] sourceArray = new int[2];
        sourceArray[0] = myI.intValue();
        sourceArray[1] = brotherI.intValue();

        return sourceArray;

    }

    private int[] fun20221002(int[] nums, int target) {
        /*
         * time: 2 ms (75.74%)
         * memory: 41.4 MB (78.02%)
         */

        Integer hitRightNum = null;
        Integer hitLeftNum = null;

        Set<Integer> leftSet = new HashSet<>();
        for (Integer rightNum : nums) {
            Integer leftNum = target - rightNum;

            if (leftSet.contains(leftNum)) {
                hitRightNum = rightNum;
                hitLeftNum = leftNum;

                break;

            } else {
                leftSet.add(rightNum);
            }
        }

        Integer hitLeftIndex = null;
        Integer hitRightIndex = null;
        for (int i = 0; i < nums.length; i++) {
            if (hitLeftIndex == null && nums[i] == hitLeftNum) {
                hitLeftIndex = i;
            } else if (hitRightIndex == null && nums[i] == hitRightNum) {
                hitRightIndex = i;
            }
        }

        int[] twoIndex = new int[2];
        twoIndex[0] = hitLeftIndex;
        twoIndex[1] = hitRightIndex;

        return twoIndex;

    }

    private int[] fun20221002x(int[] nums, int target) {
        /*
         * time: 2 ms (75.74%)
         * memory: 41.8 MB (32.17%)
         */

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

    public int[] twoSum(int[] nums, int target) {
        return fun20221002x(nums, target);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] inp = { 3, 3 };

        System.out.println("Hello World" + Arrays.toString(solution.twoSum(inp, 6)));
    }
}
