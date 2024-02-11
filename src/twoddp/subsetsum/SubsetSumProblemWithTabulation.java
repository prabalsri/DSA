package twoddp.subsetsum;

import java.util.ArrayList;
import java.util.List;

public class SubsetSumProblemWithTabulation implements SubsetSumProblem{

    public Integer size;

    public List<Integer> subset;

    public Integer targetSum;

    public SubsetSumProblemWithTabulation(List<Integer> subset, Integer targetSum) {
        this.size = subset.size();
        this.subset = subset;
        this.targetSum = targetSum;
    }

    @Override
    public Boolean isPossible() {
        return subsetSumProblemWithTabulationUtil(subset, targetSum);
    }

    @Override
    public void traceTargetSummedSubset() {

    }

    private Boolean subsetSumProblemWithTabulationUtil(List<Integer> subset, Integer targetSum) {

        List<List<Boolean>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());

        dp.get(0).add(true);
        for (int j = 1; j < this.targetSum + 1; j++) {
            dp.get(0).add(false);
        }

        for (int i = 1; i < this.size + 1; i++) {
            dp.add(new ArrayList<>());
            for (int j = 0; j < this.targetSum + 1; j++) {
                dp.get(i).add(
                    dp.get(i-1).get(j)
                    |
                    (
                        j - this.subset.get(i-1) >= 0
                        ? dp.get(i-1).get(j - this.subset.get(i-1))
                        : false
                    )
                );
            }
        }

        return dp.get(this.size).get(this.targetSum);

    }
}
