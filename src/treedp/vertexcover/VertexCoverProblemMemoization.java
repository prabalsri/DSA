package treedp.vertexcover;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

public class VertexCoverProblemMemoization implements VertexCoverProblem{

    private final List<List<Integer>> graph;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public VertexCoverProblemMemoization(List<List<Integer>> graph) {
        this.graph = graph;
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, graph.size(), 2, -1);

    }

    @Override
    public Integer minCoverSize() {
        //assuming 1 as root node
        return Math.min(
                getMinCoverSize(1, false, -1),
                getMinCoverSize(1, true, -1)
        );
    }

    private Integer getMinCoverSize(Integer currentNode, Boolean take, Integer currentNodeParent) {

        System.out.println(this.iteration++);

        if(!Objects.equals(dp.get(currentNode).get(take ? 1 : 0), -1)) {
            return dp.get(currentNode).get(take ? 1 : 0);
        }

        int minCoverSize = take ? 1 : 0;

        for (int i = 0; i < graph.get(currentNode).size(); i++) {
            if (!Objects.equals(graph.get(currentNode).get(i), currentNodeParent)) {
                if (take) {
                    minCoverSize += Math.min(
                            getMinCoverSize(graph.get(currentNode).get(i), false, currentNode),
                            getMinCoverSize(graph.get(currentNode).get(i), true, currentNode)
                    );
                } else {
                    minCoverSize += getMinCoverSize(graph.get(currentNode).get(i), true, currentNode);
                }
            }
        }

        dp.get(currentNode).set(take ? 1 : 0, minCoverSize);
        return minCoverSize;
    }
}
