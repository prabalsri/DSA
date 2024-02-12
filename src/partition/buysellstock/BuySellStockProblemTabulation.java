package partition.buysellstock;

import util.DPUtil;

import java.util.List;

public class BuySellStockProblemTabulation implements BuySellStockProblem{

    private final Integer transactions;

    private final Integer days;

    private final List<Integer> prices;

    public BuySellStockProblemTabulation(Integer transactions, List<Integer> prices){
        this.transactions = transactions;
        this.prices = prices;
        this.days = prices.size();
    }

    @Override
    public Integer maxProfit() {

        @SuppressWarnings({"unchecked"})
        List<List<Integer>> dp = (List<List<Integer>>) DPUtil.init(Integer.class, this.days + 1, 2 * this.transactions + 1);

        for (int i = this.days - 1; i >= 0; i--) {
            for (int j = 0; j < 2 * this.transactions; j++) {
                assert dp != null;
                int maxProfit = dp.get(i+1).get(j);
                if(j % 2 != 0) maxProfit = Math.max(maxProfit, dp.get(i+1).get(j+1) + this.prices.get(i));
                if(j % 2 == 0) maxProfit = Math.max(maxProfit, dp.get(i+1).get(j+1) - this.prices.get(i));

                dp.get(i).set(j, maxProfit);
            }
        }

        assert dp != null;
        return dp.get(0).get(0);
    }
}

