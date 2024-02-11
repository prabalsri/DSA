package twoddp.knapsack;

import java.util.List;
import java.util.Objects;

import util.DPUtil;

public class Knapsack01ProblemMemoization implements KnapsackProblem{

    private final Integer DEFAULT_VALUE = -1;

    private final Integer knapsackSize;

    private final Integer totalItems;

    private final List<Integer> weights;

    private final List<Integer> profits;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public Knapsack01ProblemMemoization(Integer knapsackSize, List<Integer> weights, List<Integer> profits) {
        this.knapsackSize = knapsackSize;
        this.totalItems = weights.size();
        this.weights = weights;
        this.profits = profits;
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, weights.size(), knapsackSize + 1, DEFAULT_VALUE );
    }

    @Override
    public Integer maxProfit() {
        return getMaxProfit(this.totalItems - 1, this.knapsackSize);
    }

    private Integer getMaxProfit(int index, Integer knapsackSize) {
        System.out.println(this.iteration++);

        if (index == -1) return 0;

        if(!Objects.equals(dp.get(index).get(knapsackSize), DEFAULT_VALUE)) {
            return dp.get(index).get(knapsackSize);
        }

        int ans = 0;
        if (knapsackSize - this.weights.get(index) >= 0) {
            ans = this.profits.get(index)
                    + getMaxProfit(index - 1, knapsackSize - this.weights.get(index));
        }
        ans = Math.max(ans, getMaxProfit(index - 1, knapsackSize));

        dp.get(index).set(knapsackSize, ans);
        return ans;
    }
}
