package partition.buysellstock;

import util.DPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BuySellStockProblemTabulation implements BuySellStockProblem{

    private final Integer transactions;

    private final Integer days;

    private final List<Integer> prices;

    public BuySellStockProblemTabulation(Integer transactions, List<Integer> prices){
        this.transactions = transactions;
        this.prices = prices;
        this.days = prices.size();
    }

    //TODO: Fix for 1st test case
    @Override
    public Integer maxProfit() {

        @SuppressWarnings({"unchecked"})
        List<List<Integer>> dp = (List<List<Integer>>) DPUtil.init(Integer.class, this.days + 1, 2 * this.transactions + 1);

        for (int i = 1; i <= this.days; i++) {
            for (int j = 2 * this.transactions; j > 0; j--) {
                assert dp != null;
                int maxProfit = dp.get(i-1).get(j);
                if(j % 2 != 0) maxProfit = Math.max(maxProfit, dp.get(i-1).get(j-1) + this.prices.get(i-1));
                if(j % 2 == 0) maxProfit = Math.max(maxProfit, dp.get(i-1).get(j-1) - this.prices.get(i-1));

                dp.get(i).set(j, maxProfit);
            }
        }

        assert dp != null;
        return dp.get(this.days).get(2 * this.transactions);
    }


}

