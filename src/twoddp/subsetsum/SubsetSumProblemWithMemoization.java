package twoddp.subsetsum;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

public class SubsetSumProblemWithMemoization implements SubsetSumProblem {

    private static final Boolean DEFAULT_VALUE = false;
    public Integer size;

    public List<Integer> subset;

    public Integer targetSum;

    private final List<List<Boolean>> dp;

    @SuppressWarnings({"unchecked"})
    public SubsetSumProblemWithMemoization(List<Integer> subset, Integer targetSum) {
        this.size = subset.size();
        this.subset = subset;
        this.targetSum = targetSum;
        this.dp = (List<List<Boolean>>) DPUtil.init(Boolean.class, subset.size(), targetSum + 1, DEFAULT_VALUE );
    }

    @Override
    public Boolean isPossible() {
        if (subsetSumProblemWithMemoizationUtil(this.size - 1, targetSum)) {
            System.out.print("Possible Solution: ");
            traceTargetSummedSubset();
            System.out.println();
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void traceTargetSummedSubset() {
        traceTargetSummedSubsetUtil(this.size - 1, targetSum );
    }

    public void traceTargetSummedSubsetUtil(int index, Integer targetSum) {

        if (index == -1) { return; }
        if (subsetSumProblemWithMemoizationUtil(index - 1, targetSum - this.subset.get(index))) {
            System.out.print(this.subset.get(index) + " ");
            traceTargetSummedSubsetUtil(index - 1, targetSum - this.subset.get(index));
        } else if (subsetSumProblemWithMemoizationUtil(index - 1, targetSum)) {
            traceTargetSummedSubsetUtil(index - 1, targetSum);
        }
    }

    private Boolean subsetSumProblemWithMemoizationUtil(int index, Integer targetSum) {

        //base case
        if (index == -1) {
            return Objects.equals(targetSum, 0);
        }

        if(!Objects.equals(dp.get(index).get(targetSum), DEFAULT_VALUE)) {
            return dp.get(index).get(targetSum);
        }

        boolean isPossible = false;
        if (targetSum - subset.get(index) >= 0) {
            // index is included in subset of targetSum; to do that we are moving to next index and subtracting it from targetSum
            isPossible |= subsetSumProblemWithMemoizationUtil(index - 1, targetSum - subset.get(index));
        }

        // index is excluded in subset of targetSum; to do that we are moving to next index and not subtracting it from targetSum
        isPossible |= subsetSumProblemWithMemoizationUtil(index - 1, targetSum);

        dp.get(index).set(targetSum, isPossible);

        return isPossible;

    }
}
