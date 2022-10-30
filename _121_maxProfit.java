import java.util.concurrent.atomic.AtomicInteger;

class _121_maxProfit {
    /*
     * 2022-10-27 22:17:39 -> 2022-10-27 22:58:10
     */
    private void cal(int[] prices, int limit, AtomicInteger buy, AtomicInteger sale, AtomicInteger chance) {
        // pre check
        if (limit == 0) {
            buy.set(0);
            return;
        }

        //
        AtomicInteger buyNext = new AtomicInteger(-1);
        AtomicInteger saleNext = new AtomicInteger(-1);
        AtomicInteger chanceNext = new AtomicInteger(-1);

        cal(prices, limit - 1, buyNext, saleNext, chanceNext);

        if (saleNext.get() == -1) {

            if (prices[limit] > prices[buyNext.get()]) {
                buy.set(buyNext.get());
                sale.set(limit);
            } else {
                if (prices[limit] < prices[buyNext.get()]) {
                    buy.set(limit);
                } else {
                    buy.set(buyNext.get());
                }
            }

        } else {

            if (chanceNext.get() == -1) {
                if (prices[limit] > prices[saleNext.get()]) {
                    buy.set(buyNext.get());
                    sale.set(limit);
                } else {
                    buy.set(buyNext.get());
                    sale.set(saleNext.get());

                    if (prices[limit] < prices[buyNext.get()]) {
                        chance.set(limit);
                    }
                }
            } else {
                if ((prices[limit] - prices[chanceNext.get()]) > (prices[saleNext.get()] - prices[buyNext.get()])) {
                    buy.set(chanceNext.get());
                    sale.set(limit);
                } else {
                    buy.set(buyNext.get());
                    sale.set(saleNext.get());

                    if (prices[limit] < prices[chanceNext.get()]) {
                        chance.set(limit);
                    } else {
                        chance.set(chanceNext.get());
                    }
                }
            }

        }

    }

    public int maxProfit(int[] prices) {

        AtomicInteger buy = new AtomicInteger(-1);
        AtomicInteger sale = new AtomicInteger(-1);
        AtomicInteger chance = new AtomicInteger(-1);

        cal(prices, prices.length - 1, buy, sale, chance);

        if (buy.get() != -1 && sale.get() != -1) {
            return prices[sale.get()] - prices[buy.get()];
        } else {
            return 0;
        }

    }
}
