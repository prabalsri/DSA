import treedp.treediameter.TreeDiameterProblemDFS;
import treedp.vertexcover.VertexCoverProblemDFS;
import treedp.vertexcover.VertexCoverProblemMemoization;
import util.MainUtil;

import java.util.List;

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

//        System.out.printf(
//                "Max beauty for given plates problem is -> %s. %n",
//                new PlatesProblemTabulation(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the max plate can be picked: "),
//                        (List<List<Integer>>) Objects.requireNonNull(MainUtil.getListOfListInput(Integer.class,"Enter the beauties (row x col)->(stacks x plates): "))
//                ).maxBeauty()
//        );

//        System.out.printf(
//                "Max profit for given Buy and Sell Stock problem is -> %s. %n",
//                new BuySellStockProblemMemoization(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the max transactions can be done: "),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the prices (size=days): "))
//                ).maxProfit()
//        );

//        System.out.printf(
//                "Max profit for given Buy and Sell Stock problem is -> %s. %n",
//                new BuySellStockProblemTabulation(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the max transactions can be done: "),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the prices (size=days): "))
//                ).maxProfit()
//        );

//        System.out.printf(
//                "Min of largest sum for given Split Array Min Max Sum problem is -> %s. %n",
//                new SplitArrayMinMaxSumMemoization(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the splits to be done: "),
//                        (List<Integer>) Objects.requireNonNull(MainUtil.getListInput(Integer.class,"Enter the array: "))
//                ).minimize()
//        );

//        System.out.printf(
//                "Total no. of ways in which we can fill a (2xwidth) board having (1x2, 2x1) tiles (Tiling Problem - 1) is -> %s. %n",
//                new TilingProblem1(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the width of board: ")
//                ).countWays()
//        );
//
//        System.out.printf(
//                "Total no. of ways in which we can fill a (2xwidth) board having (1x2, 2x1, 2x2) tiles (Tiling Problem - 2) is -> %s. %n",
//                new TilingProblem1(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the width of board: ")
//                ).countWays()
//        );

//        System.out.printf(
//                "Total no. of ways in which we can fill a (2xwidth) board having (1x2, 2x1, L-shaped) tiles (Tiling Problem - 3) is -> %s. %n",
//                new TilingProblem3(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the width of board: ")
//                ).countWays()
//        );

//        System.out.printf(
//                "Total no. of ways in which we can fill a (3xwidth) board having (1x2, 2x1) tiles (Tiling Problem - Advance) is -> %s. %n",
//                new TilingProblemAdvance(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the width of board: ")
//                ).countWays()
//        );

//        System.out.printf(
//                "Total no. of ways in which n friends can be paired or remain single is -> %s. %n",
//                new PairingFriendsProblem(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter the no. of friends: ")
//                ).countWays()
//        );

//        System.out.printf(
//                "Total no. of ways in which N can be partitioned into positive integers is -> %s. %n",
//                new PartitionNOrderedPairMemoized(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter N: ")
//                ).countWays()
//        );

//        System.out.printf(
//                "Total no. of ways in which N can be partitioned into positive integers is -> %s. %n",
//                new PartitionNOrderedPairTabulation(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter N: ")
//                ).countWays()
//        );

//        System.out.printf(
//                "Total no. of ways in which N can be partitioned into positive integers is -> %s. %n",
//                new PartitionNUnorderedPairMemoized(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter N: ")
//                ).countWays()
//        );

//        new DigitDPRecursion(
//                (String) MainUtil.getInput(String.class, "Enter From: "),
//                (String) MainUtil.getInput(String.class, "Enter Till: ")
//        ).printAll();

//        System.out.printf(
//                "Sum of digits of all number lies between them is -> %s. %n",
//                new SumOfDigitsProblemMemoization(
//                        (String) MainUtil.getInput(String.class, "Enter From: "),
//                        (String) MainUtil.getInput(String.class, "Enter Till: ")
//                ).sum()
//        );

//        System.out.printf(
//                "Total number of numbers whose digit sum as well as the number itself divisible by it and lies between them is -> %s. %n",
//                new NumberAndDigitSumDivisibilityProblem(
//                        (String) MainUtil.getInput(String.class, "Enter From: "),
//                        (String) MainUtil.getInput(String.class, "Enter Till: "),
//                        (Integer) MainUtil.getInput(Integer.class, "Enter Divisor: ")
//                ).checkDivisibility()
//        );

//        System.out.printf(
//                "Total number of numbers whose digit sum as well as the number itself divisible by it and lies between them is -> %s. %n",
//                new DMagicNumberProblem(
//                        (Integer) MainUtil.getInput(Integer.class, "Enter D-Magic: "),
//                        (String) MainUtil.getInput(String.class, "Enter From: "),
//                        (String) MainUtil.getInput(String.class, "Enter Till: "),
//                        (Integer) MainUtil.getInput(Integer.class, "Enter Divisor: ")
//                ).checkDivisibility()
//        );

//        System.out.printf(
//                "Size of minimal cover set of vertices which covers all the edges of the given graph is -> %s. %n",
//                new VertexCoverProblemMemoization(
//                        (List<List<Integer>>) MainUtil.getAdjacencyList("SUBMIT THE GRAPH")
//                ).minCoverSize()
//        );

//        System.out.printf(
//                "Size of minimal cover set of vertices which covers all the edges of the given graph is -> %s. %n",
//                new VertexCoverProblemDFS(
//                        (List<List<Integer>>) MainUtil.getAdjacencyList("SUBMIT THE GRAPH")
//                ).minCoverSize()
//        );

        System.out.printf(
                "Diameter of the given graph is -> %s. %n",
                new TreeDiameterProblemDFS(
                        (List<List<Integer>>) MainUtil.getAdjacencyList("SUBMIT THE GRAPH")
                ).getDiameter()
        );


    }
}















