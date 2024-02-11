package twoddp.subsetsum;

import java.util.List;
import java.util.Objects;

public class SubsetSumProblemRepeatingNumbersWithMemoization implements SubsetSumProblem {

    public Integer size;

    public List<Integer> subset;

    public Integer targetSum;

    public SubsetSumProblemRepeatingNumbersWithMemoization(List<Integer> subset, Integer targetSum) {
        this.size = subset.size();
        this.subset = subset;
        this.targetSum = targetSum;
    }

    @Override
    public Boolean isPossible() {
        return subsetSumProblemWithMemoizationUtil(this.size - 1, targetSum);
    }

    @Override
    public void traceTargetSummedSubset() {

    }

    private Boolean subsetSumProblemWithMemoizationUtil(int index, Integer targetSum) {

        //base case
        if (index == -1) {
            return Objects.equals(targetSum, 0);
        }

        //To implement memoization

        boolean isPossible = false;
        if (targetSum - subset.get(index) >= 0) {
            // index is included multiple number of times in subset of targetSum;
            // to do that we are not moving to next index and subtracting it from targetSum
            isPossible |= subsetSumProblemWithMemoizationUtil(index, targetSum - subset.get(index));
        }

        // index is excluded in subset of targetSum;
        // to do that we are moving to next index and not subtracting it from targetSum
        isPossible |= subsetSumProblemWithMemoizationUtil(index - 1, targetSum);

        return isPossible;

    }
}
