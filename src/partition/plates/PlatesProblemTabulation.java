package partition.plates;

import java.util.ArrayList;
import java.util.List;

public class PlatesProblemTabulation implements PlatesProblem{

    private static final Integer DEFAULT_VALUE = -1;
    private Integer maxPlates;

    private Integer stacks;

    private Integer stackSize;

    private List<List<Integer>> beautyStack;

    private List<List<Integer>> cumulativeBeautySumStack;

    public PlatesProblemTabulation(Integer maxPlates, List<List<Integer>> beautyStack) {
        this.maxPlates = maxPlates;
        this.beautyStack = beautyStack;
        this.stacks = beautyStack.size();
        this.stackSize = beautyStack.get(0).size();
    }


    @Override
    public Integer maxBeauty() {
        this.cumulativeBeautySumStack = calculate();
        return getMaxBeauty();
    }

    private Integer getMaxBeauty() {

        //create dp
        List<List<Integer>> dp = new ArrayList<>();
        for (int i = 0; i < this.stacks; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j <= this.maxPlates; j++) {
                list.add(0);
            }
            dp.add(list);
        }

        //initialize
        for (int j = 1; j < this.maxPlates; j++) {
            dp.get(0).set(j, this.cumulativeBeautySumStack.get(0).get(j));
        }

        //action
        for (int i = 1; i < this.stacks; i++) {
            for (int j = 0; j <= this.maxPlates; j++) {
                int maxBeauty = 0;
                for (int k = j; k >= 0 ; k--) {
                    maxBeauty = Math.max(maxBeauty, dp.get(i - 1).get(k)
                            + ( j-k <= this.stackSize ? this.cumulativeBeautySumStack.get(i).get(j - k) : 0));
                }
                dp.get(i).set(j,maxBeauty);
            }
        }

        return dp.get(this.stacks-1).get(this.maxPlates);
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
}
