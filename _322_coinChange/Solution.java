package _322_coinChange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dpTable = new int[amount + 1];

        dpTable[0] = 0;
        for (int i = 1; i < dpTable.length; i++) {
            boolean flag = false;
            for (int c : coins) {
                if (i < c) {
                    continue;
                }
                if (dpTable[i - c] == -1) {
                    continue;
                }

                if (!flag) {
                    dpTable[i] = 1 + dpTable[i - c];
                    flag = true;
                } else {
                    if (1 + dpTable[i - c] < dpTable[i]) {
                        dpTable[i] = 1 + dpTable[i - c];
                    }
                }
            }
            if (!flag) {
                dpTable[i] = -1;
            }

        }

        return dpTable[amount];
    }

    public static void main(String[] args) {
        new Solution().coinChange(new int[] { 1, 2, 5 }, 11);
    }
}
