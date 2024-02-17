package combinatorics.partitionnpositiveintegers;

import util.DPUtil;

import java.util.List;

public class PartitionNOrderedPairTabulation implements PartitionN{

    private final Integer N;

    private List<Integer> dp;

    @SuppressWarnings("unchecked")
    public PartitionNOrderedPairTabulation(Integer N) {
        this.N = N;
        this.dp = (List<Integer>) DPUtil.init(Integer.class, 1, N + 1);
    }

    @Override
    public Integer countWays() {

        int sum = 0;
        for (int i = 1; i <= this.N; i++) {
            this.dp.set(i, sum + 1);
            sum += this.dp.get(i);
        }
        return this.dp.get(this.N);
    }
}
