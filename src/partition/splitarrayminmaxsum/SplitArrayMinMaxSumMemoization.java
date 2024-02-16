package partition.splitarrayminmaxsum;

import util.DPUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SplitArrayMinMaxSumMemoization implements SplitArrayMinMaxSum{

    private final Integer DEFAULT_VALUE = -1;

    private final Integer arraySize;

    private final Integer splits;

    private final List<Integer> array;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public SplitArrayMinMaxSumMemoization(Integer splits, List<Integer> array) {
        this.arraySize = array.size();
        this.splits = splits;
        this.array = array;
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, this.arraySize + 1, this.splits + 1, DEFAULT_VALUE);
    }

    @Override
    public Integer minimize() {
        return this.getMinimizedValue(0, this.splits);
    }

    private Integer getMinimizedValue(int index, Integer splits) {

        System.out.println(this.iteration++);

        if(index == this.arraySize) {
            if(splits == 0) {
                return 0;
            }
            return Integer.MAX_VALUE;
        }
        if(splits <= 0) {
            return Integer.MAX_VALUE;
        }

        if(!Objects.equals(dp.get(index).get(splits), DEFAULT_VALUE)) {
            return dp.get(index).get(splits);
        }

        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i = index; i < this.arraySize; i++) {
            sum += this.array.get(i);
            min = Math.min(min, Math.max(sum, getMinimizedValue(i + 1, splits - 1)));
        }

        dp.get(index).set(splits, min);

        return min;
    }
}
