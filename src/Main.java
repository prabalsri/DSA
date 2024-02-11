import partition.plates.PlatesProblemMemoization;
import partition.plates.PlatesProblemTabulation;
import twoddp.painthouse.PaintHouseProblemTabulationSuperSpaceOptimized;
import util.MainUtil;

import java.util.List;
import java.util.Objects;

public class Main {

    @SuppressWarnings({"unchecked"})
    public static void main(String[] args) {

//        System.out.printf(
//                "Possibility of below subset sum problem is -> %s. %n",
//            new SubsetSumProblemWithMemoization(
//                    (List<Integer>) Objects.requireNonNull(util.MainUtil.getListInput(Integer.class,"Enter the subset: ")),
//                    (Integer) util.MainUtil.getInput(Integer.class, "Enter the target sum: ")
//            ).isPossible() ? "1" : "0"
//        );

//        System.out.printf(
//                "Possibility of below subset sum problem is -> %s. %n",
//                new SubsetSumProblemRepeatingNumbersWithMemoization(
//                        (List<Integer>) Objects.requireNonNull(util.MainUtil.getListInput(Integer.class,"Enter the subset: ")),
//                        (Integer) util.MainUtil.getInput(Integer.class, "Enter the target sum: ")
//                ).isPossible() ? "1" : "0"
//        );

//        System.out.printf(
//                "Possibility of below subset sum problem is -> %s. %n",
//                new SubsetSumProblemWithTabulation(
//                        (List<Integer>) Objects.requireNonNull(util.MainUtil.getListInput(Integer.class,"Enter the subset: ")),
//                        (Integer) util.MainUtil.getInput(Integer.class, "Enter the target sum: ")
//                ).isPossible() ? "1" : "0"
//        );

//        System.out.printf(
//                "Max profit for given 0/1 knapsack problem is -> %s. %n",
//                new Knapsack01ProblemMemoization(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the max size of knapsack: "),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the weights: ")),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the profits: "))
//                ).maxProfit()
//        );

//        System.out.printf(
//                "Max profit for given 0/N knapsack problem is -> %s. %n",
//                new Knapsack0NProblemMemoization(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the max size of knapsack: "),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the weights: ")),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the profits: "))
//                ).maxProfit()
//        );

//        System.out.printf(
//                "Minimum cost for given paint house problem is -> %s. %n",
//                new PaintHouseProblemMemoization(
//                        (List<List<Integer>>) Objects.requireNonNull(MainUtil.getListOfListInput(Integer.class,"Enter the costs (row x col)->(houses x colors): "))
//                ).minimumCost()
//        );

//        System.out.printf(
//                "Minimum cost for given paint house problem is -> %s. %n",
//                new PaintHouseProblemTabulationSuperSpaceOptimized(
//                        (List<List<Integer>>) Objects.requireNonNull(MainUtil.getListOfListInput(Integer.class,"Enter the costs (row x col)->(houses x colors): "))
//                ).minimumCost()
//        );

        System.out.printf(
                "Max beauty for given plates problem is -> %s. %n",
                new PlatesProblemTabulation(
                        (Integer) MainUtil.getInput(Integer.class, "Enter the max plate can be picked: "),
                        (List<List<Integer>>) Objects.requireNonNull(MainUtil.getListOfListInput(Integer.class,"Enter the beauties (row x col)->(stacks x plates): "))
                ).maxBeauty()
        );

        //Test commit
    }
}















