package twoddp.painthouse;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

public class PaintHouseProblemMemoization  implements PaintHouseProblem {

    private final Integer DEFAULT_VALUE = -1;

    private final Integer houses;

    private final Integer colors;

    private final List<List<Integer>> costs;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public PaintHouseProblemMemoization(List<List<Integer>> costs) {
        this.houses = costs.get(0).size();
        this.colors = costs.size();
        this.costs = costs;
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, this.colors, this.houses + 1, DEFAULT_VALUE);
    }


    @Override
    public Integer minimumCost() {
        int ans = Math.min(getMinimumCost(this.houses - 1, 0), getMinimumCost(this.houses - 1, 1));
        ans = Math.min(ans, getMinimumCost(this.houses - 1, 2));
        return ans;
    }

    private Integer getMinimumCost(Integer house, Integer color) {

        System.out.println(this.iteration++);

        if (house == -1) return 0;

        if(!Objects.equals(dp.get(color).get(house), DEFAULT_VALUE)) {
            return dp.get(color).get(house);
        }

        int ans = 99999;

        if (color != 0) ans = Math.min(ans, this.costs.get(color).get(house) + getMinimumCost(house - 1, 0));
        if (color != 1) ans = Math.min(ans, this.costs.get(color).get(house) + getMinimumCost(house - 1, 1));
        if (color != 2) ans = Math.min(ans, this.costs.get(color).get(house) + getMinimumCost(house - 1, 2));

        dp.get(color).set(house, ans);

        return ans;
    }
}
