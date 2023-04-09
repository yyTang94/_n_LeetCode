package _322_coinChange;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] coinMinArr = new int[amount + 1];
        for (int i = 0; i < coinMinArr.length; i++) {
            coinMinArr[i] = Integer.MAX_VALUE;
        }

        // 0
        coinMinArr[0] = 0;

        // 1 - amount
        for (int i = 1; i < coinMinArr.length; i++) {
            for (int j : coins) {
                int c = Integer.MAX_VALUE;
                if (i - j == 0) {
                    c = 1;
                } else if (i - j < 0) {
                    c = Integer.MAX_VALUE;
                } else {
                    c = coinMinArr[i - j] == Integer.MAX_VALUE ? Integer.MAX_VALUE : 1 + coinMinArr[i - j];
                }
                if (c < coinMinArr[i]) {
                    coinMinArr[i] = c;
                }
            }
        }

        return coinMinArr[coinMinArr.length - 1] == Integer.MAX_VALUE ? -1 : coinMinArr[coinMinArr.length - 1];
    }
}
