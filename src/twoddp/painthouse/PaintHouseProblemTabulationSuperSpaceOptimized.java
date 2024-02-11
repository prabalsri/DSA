package twoddp.painthouse;

import java.util.List;

public class PaintHouseProblemTabulationSuperSpaceOptimized implements PaintHouseProblem {

    private final Integer DEFAULT_VALUE = -1;

    private final Integer houses;

    private final Integer colors;

    private final List<List<Integer>> costs;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public PaintHouseProblemTabulationSuperSpaceOptimized(List<List<Integer>> costs) {
        this.houses = costs.get(0).size();
        this.colors = costs.size();
        this.costs = costs;
    }

    @Override
    public Integer minimumCost() {

        int[] dp = {0,0,0,0,0};

        for (int i = 0; i < this.houses; i++) {
            for (int j = 0; j < this.colors; j++) {
                dp[j] = Math.min(dp[j+1], dp[j+2]) + this.costs.get(j).get(i);
            }
            dp[3] = dp[0];
            dp[4] = dp[1];
        }
        return Math.min(Math.min(dp[0], dp[1]), dp[2]);

    }
}

