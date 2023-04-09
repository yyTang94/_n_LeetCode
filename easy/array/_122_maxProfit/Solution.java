package easy.array._122_maxProfit;

import java.util.Objects;

class Solution {
    /*
     * 查找“非下降区间”
     */
    public int maxProfit(int[] prices) {
        // pre check
        if (Objects.isNull(prices) || prices.length <= 1) {
            return 0;
        }

        // problem answer
        int aggProfit = 0;

        // iter keys
        int fragStart = 0;
        int fragLength = 2;
        while (true) {
            int fragEnd = fragStart + fragLength - 1;
            int fragBeforeEnd = fragEnd - 1;

            // exit
            if (fragEnd > prices.length - 1) {
                aggProfit += prices[fragBeforeEnd] - prices[fragStart];

                break;
            }

            // iter
            if (prices[fragEnd] >= prices[fragBeforeEnd]) {
                fragLength++;
            } else {
                aggProfit += prices[fragBeforeEnd] - prices[fragStart];

                fragStart = fragEnd;
                fragLength = 2;
            }
        }

        return aggProfit;
    }
}
