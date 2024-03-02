package treedp.vertexcover;

import util.DPUtil;

import java.util.List;
import java.util.Objects;

public class VertexCoverProblemDFS implements VertexCoverProblem{

    private final List<List<Integer>> graph;

    private final List<List<Integer>> dp;

    private Integer iteration = 0;

    @SuppressWarnings({"unchecked"})
    public VertexCoverProblemDFS(List<List<Integer>> graph) {
        this.graph = graph;
        this.dp = (List<List<Integer>>) DPUtil.init(Integer.class, graph.size(), 2, 0);

    }

    @Override
    public Integer minCoverSize() {
        //assuming 1 as root node
        getMinCoverSizeDFS(1, -1);
        return Math.min(dp.get(1).get(0), dp.get(1).get(1));
    }

    private void getMinCoverSizeDFS(Integer currentNode, Integer currentNodeParent) {

        System.out.println(this.iteration++);

        int takeNot = 0;
        int take = 1;

        for (int i = 0; i < graph.get(currentNode).size(); i++) {
            if (!Objects.equals(graph.get(currentNode).get(i), currentNodeParent)) {
                getMinCoverSizeDFS(this.graph.get(currentNode).get(i), currentNode);

                takeNot += dp.get(this.graph.get(currentNode).get(i)).get(1);
                take += Math.min(dp.get(this.graph.get(currentNode).get(i)).get(0), dp.get(this.graph.get(currentNode).get(i)).get(1));

            }
        }

        dp.get(currentNode).set(0, takeNot);
        dp.get(currentNode).set(1, take);
    }
}
