class _122_maxProfit {
    public int maxProfit(int[] prices) {

        /*
         * 2022-10-03 11:59:52
         * time: 0 ms (100.00%)
         * memory: 41.6 MB (21.34%)
         */

        int earn = 0;

        int slow = 0;
        int fast = 1;

        boolean statu = false;
        boolean trend = false;

        while (fast < prices.length) {
            if (!statu) {
                if (prices[fast] > prices[fast - 1]) {
                    statu = true;
                    trend = true;

                    fast++;
                } else if (prices[fast] < prices[fast - 1]) {
                    statu = true;
                    trend = false;

                    fast++;
                } else {
                    fast++;
                }
            } else {
                if (trend) {
                    if (prices[fast] >= prices[fast - 1]) {
                        fast++;
                    } else {
                        earn += prices[fast - 1] - prices[slow];

                        slow = fast - 1;

                        statu = false;
                        trend = false;
                    }
                } else {
                    if (prices[fast] <= prices[fast - 1]) {
                        fast++;
                    } else {
                        slow = fast - 1;

                        statu = false;
                        trend = false;
                    }
                }
            }
        }

        if (statu && trend) {
            earn += prices[fast - 1] - prices[slow];
        }

        return earn;

    }
}
