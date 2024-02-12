package partition.buysellstock;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

public class BuySellStockProblemMemoization implements BuySellStockProblem{

    private final Integer DEFAULT_VALUE = -1;

    private final Integer transactions;

    private final Integer days;

    private final List<Integer> prices;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public BuySellStockProblemMemoization(Integer transactions, List<Integer> prices){
        this.transactions = transactions;
        this.prices = prices;
        this.days = prices.size();
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, this.days, 2 * this.transactions + 1, DEFAULT_VALUE);

    }

    @Override
    public Integer maxProfit() {
        return Math.max(getMaxProfit(0, 2 * this.transactions - 1) - this.prices.get(0),
                getMaxProfit(0, 2 * this.transactions));
    }

    private Integer getMaxProfit(int day, int transactions) {

        System.out.println(this.iteration++);

        if (day == this.days || transactions == 0) {
            return 0;
        }

        if(!Objects.equals(dp.get(day).get(transactions), DEFAULT_VALUE)) {
            return dp.get(day).get(transactions);
        }

        int maxProfit = getMaxProfit(day + 1, transactions); //skip
        if(transactions % 2 == 0) { //buy
            maxProfit = Math.max(maxProfit, getMaxProfit(day + 1, transactions - 1) - this.prices.get(day));
        } else { //sell
            maxProfit = Math.max(maxProfit, getMaxProfit(day + 1, transactions - 1) + this.prices.get(day));
        }

        dp.get(day).set(transactions, maxProfit);

        return maxProfit;
    }
}
