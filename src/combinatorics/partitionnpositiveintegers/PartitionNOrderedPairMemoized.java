package combinatorics.partitionnpositiveintegers;

import util.DPUtil;

import java.util.List;

public class PartitionNOrderedPairMemoized implements PartitionN{

    private final Integer N;

    private List<Integer> dp;

    private Integer iteration = 0;

    @SuppressWarnings("unchecked")
    public PartitionNOrderedPairMemoized(Integer N) {
        this.N = N;
        this.dp = (List<Integer>) DPUtil.init(Integer.class, 1, N + 1);
    }

    @Override
    public Integer countWays() {
        return getTotalWays(this.N);
    }

    private Integer getTotalWays(Integer N) {

        System.out.println(++this.iteration);

        if(N == 0) {
            return 1;
        }

        if(this.dp.get(N) != -1) {
            return this.dp.get(N);
        }

        int totalWays = 0;
        for (int i = 1; i <= N; i++) {
            totalWays += getTotalWays(N - i);
        }

        this.dp.set(N, totalWays);
        return totalWays;
    }
}
