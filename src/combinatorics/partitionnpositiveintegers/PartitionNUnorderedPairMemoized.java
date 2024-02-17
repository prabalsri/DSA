package combinatorics.partitionnpositiveintegers;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

import static util.DPUtil.DEFAULT_INTEGER;

public class PartitionNUnorderedPairMemoized implements PartitionN{

    private final Integer N;

    private List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings("unchecked")
    public PartitionNUnorderedPairMemoized(Integer N) {
        this.N = N;
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, N + 1, N + 1);
    }

    @Override
    public Integer countWays() {
        return getTotalWays(1, this.N);
    }

    private Integer getTotalWays(Integer initialPartition, Integer N) {

        System.out.println(++this.iteration);

        if(N == 0) {
            return 1;
        }

        if(!Objects.equals(dp.get(initialPartition).get(N), DEFAULT_INTEGER)) {
            return dp.get(initialPartition).get(N);
        }

        int totalWays = 0;
        for (int i = initialPartition; i <= N; i++) {
            totalWays += getTotalWays(i,N - i);
        }

        dp.get(initialPartition).set(N, totalWays);
        return totalWays;
    }
}
