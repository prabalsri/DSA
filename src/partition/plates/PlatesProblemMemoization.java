package partition.plates;


import util.DPUtil;

import java.util.ArrayList;
import java.util.List;

public class PlatesProblemMemoization implements PlatesProblem{

    private static final Integer DEFAULT_VALUE = -1;
    private Integer maxPlates;

    private Integer stacks;

    private Integer stackSize;

    private List<List<Integer>> beautyStack;

    private List<List<Integer>> cumulativeBeautySumStack;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public PlatesProblemMemoization(Integer maxPlates, List<List<Integer>> beautyStack) {
        this.maxPlates = maxPlates;
        this.beautyStack = beautyStack;
        this.stacks = beautyStack.size();
        this.stackSize = beautyStack.get(0).size();
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, this.stacks + 1, this.stackSize + 1, DEFAULT_VALUE);
    }


    @Override
    public Integer maxBeauty() {
        this.cumulativeBeautySumStack = calculate();
        return getMaxBeauty(this.stacks, 0, 0);
    }

    private List<List<Integer>> calculate() {
        List<List<Integer>> cumulativeBeautySumStack = new ArrayList<>();
        for (int i = 0; i < this.stacks; i++) {
            List<Integer> cumulativeBeautySum = new ArrayList<>();
            for (int j = 0; j < this.stackSize + 1; j++) {
                if (j == 0) {
                    cumulativeBeautySum.add(0);
                } else {
                    cumulativeBeautySum.add(this.beautyStack.get(i).get(j-1) + cumulativeBeautySum.get(j - 1));
                }
            }
            cumulativeBeautySumStack.add(cumulativeBeautySum);
        }
        return cumulativeBeautySumStack;
    }

    private Integer getMaxBeauty(Integer stack, int plate, int platesInHand) {

        System.out.println(this.iteration++);

        if(stack == -1 || plate > this.stackSize) return 0;

        //TODO: Fix memoization for 2nd test case
//        if(!Objects.equals(dp.get(stack).get(plate), DEFAULT_VALUE)) {
//            return dp.get(stack).get(plate);
//        }

        int maxBeauty = 0;
        for (int i = 0; i <= this.maxPlates - platesInHand; i++) {
            maxBeauty = Math.max(maxBeauty, getMaxBeauty(stack - 1, i, plate + i) + (stack < this.stacks ? this.cumulativeBeautySumStack.get(stack).get(plate) : 0));
        }

        //dp.get(stack).set(plate, maxBeauty);
        return maxBeauty;
    }
}
